package com.example.wtest.web.ws

import com.example.wtest.web.responses.ContentResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ContentWebservice {

    @GET("/repos/{owner}/{repo}/contents/{path}")
    fun getContent(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("path") path: String
    ): Call<ContentResponse>
}