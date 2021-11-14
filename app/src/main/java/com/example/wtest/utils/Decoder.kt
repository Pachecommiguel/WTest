package com.example.wtest.utils

import android.util.Base64

object Decoder {

    fun decodeFromBase64(content: String?): List<List<String>?> {
        val bytes = Base64.decode(content, Base64.DEFAULT).toString(charset("UTF-8"))
        var lines = bytes.split("\n")
        lines = lines.drop(1)
        lines = lines.dropLast(1)
        val regex = "\\d{4}[,]\\d{3}.+".toRegex()
        val list = lines.map { regex.find(it)?.value }

        return list.map { it?.split(",") }
    }
}