package com.example.wtest.web.responses

import com.google.gson.annotations.SerializedName

data class Links(
    @SerializedName("git") val git : String,
    @SerializedName("self") val self : String,
    @SerializedName("html") val html : String
)
