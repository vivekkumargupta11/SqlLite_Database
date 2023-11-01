package com.example.sqllite_database

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


    class MyAdapter(val context: android.content.Context, private val listItem:ArrayList<User_Model>) : RecyclerView.Adapter<MyAdapter.ViewHoler>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHoler {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)
            return ViewHoler(view)
        }

        override fun getItemCount(): Int {
            return listItem.size
        }

        override fun onBindViewHolder(holder: ViewHoler, position: Int) {
            val itemPosition = listItem[position]
            holder.entername.text = "Name-->"+itemPosition.name
            holder.enteremail.text ="Email-->"+itemPosition.email.toString()

        }

        class ViewHoler(itemView: View): RecyclerView.ViewHolder(itemView) {
            val entername: TextView = itemView.findViewById(R.id.name1)
            val enteremail: TextView = itemView.findViewById(R.id.email1)
        }

}