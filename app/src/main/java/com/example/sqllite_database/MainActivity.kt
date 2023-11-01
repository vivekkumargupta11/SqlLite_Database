package com.example.sqllite_database

import android.annotation.SuppressLint
import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var entername: EditText
    lateinit var enteremail: EditText
    lateinit var button: Button
    lateinit var recyclerView: RecyclerView
    lateinit var listItem : ArrayList<User_Model>
    lateinit var myAdapter: MyAdapter

    @SuppressLint("MissingInflatedId", "Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        entername = findViewById(R.id.EdtName)
        enteremail = findViewById(R.id.EdtEmail)
        button = findViewById(R.id.button)
        recyclerView= findViewById(R.id.recyclerView)
        recyclerView.layoutManager=GridLayoutManager(this,1)

        listItem = arrayListOf()
        myAdapter = MyAdapter(applicationContext,listItem)

        var heleper = MyHeleper(applicationContext)
        val db = heleper.readableDatabase
        var rs = db.rawQuery("SELECT * FROM USERS", null)

        if (rs.moveToNext())
            Toast.makeText(applicationContext, "rs.getString(1)", Toast.LENGTH_SHORT).show()

        button.setOnClickListener {
            var cv = ContentValues()
            cv.put("UNAME", entername.text.toString())
            cv.put("EMAIL", enteremail.text.toString())
            db.insert("USERS", null, cv)

            entername.setText("")
            enteremail.setText("")
            entername.requestFocus()
        }

        val cursor = db.rawQuery("SELECT * FROM USERS", null)
        if (cursor.moveToNext()){
            do{

                val name = cursor.getString(cursor.getColumnIndex("UNAME"))
                val email = cursor.getString(cursor.getColumnIndex("EMAIL"))
                val data = User_Model(name.toString(),email.toString())
                listItem.add(data)
                myAdapter.notifyDataSetChanged()

            }while (cursor.moveToNext())
        }
        recyclerView.adapter = myAdapter
    }
}
