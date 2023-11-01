package com.example.sqllite_database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class MyHeleper(context: Context) : SQLiteOpenHelper(context,"users",null,1) {
    override fun onCreate(db: SQLiteDatabase?) {
   db?.execSQL("CREATE TABLE USERS(USERSID INTEGER PRIMARY KEY AUTOINCREMENT,UNAME TEXT,EMAIL TEXT)")
    db?.execSQL("INSERT INTO USERS(UNAME,EMAIL) VALUES ('vivek','vivek@gmail.com')")
    db?.execSQL("INSERT INTO USERS(UNAME,EMAIL) VALUES ('sonu','sonu@gmail.com')")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
}