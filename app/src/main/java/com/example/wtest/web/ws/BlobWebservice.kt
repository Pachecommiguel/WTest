package com.example.wtest.web.ws

import com.example.wtest.web.responses.BlobResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface BlobWebservice {

    @GET("/repos/{owner}/{repo}/git/blobs/{path}")
    fun getBlob(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("path") path: String
    ): Call<BlobResponse>
}