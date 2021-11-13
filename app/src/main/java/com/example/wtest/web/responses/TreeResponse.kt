package com.example.wtest.web.responses

data class TreeResponse(
    val sha : String,
    val url : String,
    val tree : List<Tree>,
    val truncated : Boolean
)
