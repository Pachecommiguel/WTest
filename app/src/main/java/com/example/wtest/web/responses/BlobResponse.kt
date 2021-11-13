package com.example.wtest.web.responses

import com.google.gson.annotations.SerializedName

data class BlobResponse (
    val content : String,
    val encoding : String,
    val url : String,
    val sha : String,
    val size : Int,
    @SerializedName("node_id") val nodeId : String
)