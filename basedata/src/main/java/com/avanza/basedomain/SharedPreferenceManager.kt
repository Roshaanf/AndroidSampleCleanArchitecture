package com.data.common

import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SharedPreferenceManager @Inject constructor(var preferences: SharedPreferences) {

    fun clearPrefs(): Boolean {
        return preferences.edit().clear().commit()
    }

    fun putString(field: String, value: String?) {
        preferences.edit().putString(field, value).apply()
    }

    fun getString(field: String, defaultValue: String): String? {
        return preferences.getString(field, defaultValue)
    }

    fun putBoolean(field: String, value: Boolean) {
        preferences.edit().putBoolean(field, value).apply()
    }

    fun getBoolean(field: String, defaultValue: Boolean): Boolean {
        return preferences.getBoolean(field, defaultValue)
    }

    fun putInteger(field: String, value: Int) {
        preferences.edit().putInt(field, value).apply()
    }

    fun getInteger(field: String, defaultValue: Int): Int {
        return preferences.getInt(field, defaultValue)
    }


    object SharedPrefConst {
        const val SHARED_PREF_FILE = "SSH_pref_file"
    }

}