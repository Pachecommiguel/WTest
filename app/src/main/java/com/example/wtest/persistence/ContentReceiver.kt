package com.example.wtest.persistence

interface ContentReceiver {
    fun onNewContent(content: String?)
}