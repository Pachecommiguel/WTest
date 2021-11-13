package com.example.wtest.utils

import android.util.Base64

abstract class Decoder {

    companion object {
        fun decode(content: String?): List<List<String>?> {
            val decoded = Base64.decode(content, Base64.DEFAULT).toString(charset("UTF-8"))
            var lines = decoded.split("\n")
            lines = lines.drop(1)
            lines = lines.dropLast(1)
            val regex = "\\d{4}[,]\\d{3}.+".toRegex()
            val list = lines.map { regex.find(it)?.value }

            return list.map { it?.split(",") }
        }
    }
}