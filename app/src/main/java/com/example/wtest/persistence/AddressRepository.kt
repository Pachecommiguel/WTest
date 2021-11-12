package com.example.wtest.persistence

import com.example.wtest.web.ws.ContentWebservice
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AddressRepository @Inject constructor(
    private val webservice: ContentWebservice
) {
}