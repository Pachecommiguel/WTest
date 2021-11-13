package com.example.wtest.web.responses

import com.google.gson.annotations.SerializedName

data class ContentResponse (
    val type : String,
    val encoding : String,
    val size : Int,
    val name : String,
    val path : String,
    val content : String,
    val sha : String,
    val url : String,
    @SerializedName("git_url") val gitUrl : String,
    @SerializedName("html_url") val htmlUrl : String,
    @SerializedName("download_url") val downloadUrl : String,
    @SerializedName("_links") val links : Links
)