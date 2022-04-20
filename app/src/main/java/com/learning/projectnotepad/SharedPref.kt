package com.learning.projectnotepad

import android.content.Context

class SharedPref (context: Context) {
    var sharedPref = context.getSharedPreferences("my pref", Context.MODE_PRIVATE)
    val editor = sharedPref.edit()

    fun saveData(key : String , value : String){
        editor.apply{
            putString(key,value)
            apply()
        }
    }

    fun retrieveData(key : String):String {
        return  sharedPref.getString(key.toString(), "No Notes")!!
    }
}