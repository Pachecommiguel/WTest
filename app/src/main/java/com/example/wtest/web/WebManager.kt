package com.example.wtest.web

import com.example.wtest.persistence.ContentReceiver
import com.example.wtest.web.responses.BlobResponse
import com.example.wtest.web.responses.TreeResponse
import com.example.wtest.web.ws.BlobWebservice
import com.example.wtest.web.ws.TreeWebservice
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class WebManager @Inject constructor(
    private val blobWs: BlobWebservice,
    private val treeWs: TreeWebservice
) {

    private lateinit var receiver: ContentReceiver

    companion object {
        private const val OWNER = "centraldedados"
        private const val REPO = "codigos_postais"
        private const val BRANCH = "master"
        private const val PATH = "data"
        private const val FILE_NAME = "codigos_postais.csv"
    }

    fun setReceiver(receiver: ContentReceiver) {
        this.receiver = receiver
    }

    fun getAddress() {
        treeWs.getTree(OWNER, REPO, BRANCH, PATH).enqueue(object : Callback<TreeResponse> {
            override fun onResponse(
                call: Call<TreeResponse>,
                response: Response<TreeResponse>
            ) {
                response.body()?.tree?.forEach {
                    if (it.path == FILE_NAME) getContent(it.sha)
                }
            }

            override fun onFailure(call: Call<TreeResponse>, t: Throwable) {
                getAddress()
            }
        })
    }

    private fun getContent(sha: String) {
        blobWs.getBlob(OWNER, REPO, sha).enqueue(object : Callback<BlobResponse> {
            override fun onResponse(
                call: Call<BlobResponse>,
                response: Response<BlobResponse>
            ) {
                receiver.onNewContent(response.body()?.content)
            }

            override fun onFailure(call: Call<BlobResponse>, t: Throwable) {
                getContent(sha)
            }
        })
    }
}