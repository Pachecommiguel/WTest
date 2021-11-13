package com.example.wtest.utils

import android.content.Context
import android.content.Context.MODE_PRIVATE
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Preferences @Inject constructor(
    @ApplicationContext private val context: Context
) {

    companion object {
        private const val FIRST_RUN = "first_run"
        private const val NAME = "com.example.wtest"
    }

    fun isFirstTimeLaunch(): Boolean {
        val preferences = context.getSharedPreferences(NAME, MODE_PRIVATE)
        return preferences.getBoolean(FIRST_RUN, true)
    }

    fun setFirstTimeLaunch(value: Boolean) {
        val preferences = context.getSharedPreferences(NAME, MODE_PRIVATE)
        preferences.edit().putBoolean(FIRST_RUN, value).apply()
    }
}