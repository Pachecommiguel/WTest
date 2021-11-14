package com.example.wtest.utils

object RegexUtil {

    fun getDigits(newText: String): List<String> {
        val text = newText.uppercase().trim()
        val digitsRegex = "[0-9]+".toRegex()

        return digitsRegex.findAll(text).map { it.value }.toList()
    }

    fun getLocation(newText: String): String? {
        val text = newText.uppercase().trim()
        val locationRegex = "[A-ZÀ-ú\\s]+".toRegex()

        return locationRegex.find(text)?.value?.trim()
    }
}