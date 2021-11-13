package com.example.wtest.utils

import android.util.Base64

abstract class Decoder {

    companion object {
        fun decode(content: String?): String = Base64.decode(content, Base64.DEFAULT)
            .toString(charset("UTF-8"))
    }
}