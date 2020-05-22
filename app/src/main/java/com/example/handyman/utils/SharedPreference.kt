package com.example.handyman.utils

import android.content.Context
import android.content.SharedPreferences

class SharedPreference (val context : Context){

    private val PREF_NAME = "feminie"
    private val sharedPref: SharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    fun saveToken(KEY_NAME : String , text : String){
        val editor = sharedPref.edit()
        editor.putString(KEY_NAME,text)
        editor.apply()
    }
    fun getToken(KEY_NAME : String): String?{
       return sharedPref.getString(KEY_NAME,null)
    }
}