package com.example.wtest.web.responses

data class Tree (
    val path : String,
    val mode : Int,
    val type : String,
    val sha : String,
    val size : Int,
    val url : String
)
