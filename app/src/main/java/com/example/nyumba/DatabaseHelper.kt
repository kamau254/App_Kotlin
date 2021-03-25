package com.example.nyumba

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class  DatabaseHelper(context: Context) :SQLiteOpenHelper(context, dbname,factory, version){
    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL(sql: "create table user(id interger primary key autoincrement, "+" username varchar(30),
        fname varchar(30), lname varchar(30), email varchar(100), town varchar(30), phone varchar(30)
        password varchar(30), confirmPassword varchar(30)"))
    }

    override fun onUpgrade(p0: SQLiteDatabase?p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    fun insertUserData(username:String, fname:String, lname:String, email:String, town:String, phone:String,
                       password:String ){
        val db:SQLiteDatabase = writableDatabase
        val values: ContentValues = ContentValues()
        values.put("username",username)
        values.put("fname",fname)
        values.put("lname",lname)
        values.put("email",email)
        values.put("town",town)
        values.put("phone",phone)
        values.put("password",password)
        //values.put("confirmPassword",confirmPassword)

        db.insert("user", null,values)
        db.close()
    }

    fun userPresent(email: String,password: String){
        val db = writableDatabase
        val query = "select * from user where email = $email and password = $password"
        val cursor = db.rawQuery(query, null)
        if (cursor.count<=0){
            cursor.close()
            return false
        }
        cursor.close()
        return true

    }

    fun insertUserData(username: String, fname: String, lname: String, email: String,
                       town: String, phone:, password: String) {

    }

    companion object{
        internal val dbname = "userDB"
        internal val factory = null
        internal val version = 1

    }
}