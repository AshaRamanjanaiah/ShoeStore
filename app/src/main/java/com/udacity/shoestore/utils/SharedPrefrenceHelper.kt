package com.udacity.shoestore.utils

import android.content.Context
import android.content.SharedPreferences

const val ONBOARDING_DISPLAY = "onboarding_displayed"
const val SHOE_LIST = "shoe_list"
const val LOGGED_OUT = "logged_out"

fun getPrefs(context: Context): SharedPreferences =
    context.getSharedPreferences(SHOE_LIST, Context.MODE_PRIVATE)

fun setPrefBoolean(context: Context, key: String, value: Boolean) {
    val editor: SharedPreferences.Editor = getPrefs(context).edit()
    editor.putBoolean(key, value)
    editor.apply()
}

fun getPrefBoolean(context: Context, key: String): Boolean {
    return getPrefs(context).getBoolean(key, false)
}

