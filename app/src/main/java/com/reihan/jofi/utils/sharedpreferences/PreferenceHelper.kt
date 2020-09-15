package com.reihan.jofi.utils.sharedpreferences

import android.content.Context
import android.content.SharedPreferences

class PreferenceHelper(context: Context) {

    private lateinit var sharedprefrences : SharedPreferences
    private var PREFERENCES_NAME = "PREFERENCE_NAME"
    var editor : SharedPreferences.Editor

    init {
        sharedprefrences = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)
        editor = sharedprefrences.edit()
    }

    fun put(key: String, value: String){
        editor.putString(key, value)
            .apply()
    }

    fun put(key: String, value: Boolean) {
        editor.putBoolean(key, value)
            .apply()
    }
    fun getString( key: String ): String? {
        return sharedprefrences.getString(key, null)
    }
    fun getInt( key: String ): Int? {
        return sharedprefrences.getInt(key, 0)
    }
    fun getBoolean( key: String ): Boolean?{
        return sharedprefrences.getBoolean(key, false)
    }

    fun clear(){
        editor.clear().apply()
    }

//    fun put(key: String, value: Int) {
//        editor.putInt(key, value)
//            .apply()
//    }
//    fun put(key: String, value: Float) {
//        editor.putFloat(key, value)
//            .apply()
//    }
//    fun put(key: String, value: Long) {
//        editor.putLong(key, value)
//            .apply()
//    }
//
//    fun put(key: String, value: Set<String>) {
//        editor.putStringSet(key, value)
//            .apply()
//    }

//    fun getLong( key: String ): Long? {
//        return sharedprefrences.getLong(key, 0)
//    }
//    fun getFloat( key: String ): Float {
//        return sharedprefrences.getFloat(key)
//    }

}