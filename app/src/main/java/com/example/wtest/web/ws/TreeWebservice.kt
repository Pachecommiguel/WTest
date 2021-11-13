package com.example.wtest.web.ws

import com.example.wtest.web.responses.TreeResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface TreeWebservice {

    @GET("/repos/{owner}/{repo}/git/trees/{branch}:{path}")
    fun getTree(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("branch") branch: String,
        @Path("path") path: String
    ): Call<TreeResponse>
}