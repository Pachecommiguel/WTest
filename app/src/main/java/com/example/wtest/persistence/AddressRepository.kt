package com.example.wtest.persistence

import androidx.lifecycle.LiveData
import com.example.wtest.persistence.entities.Address
import com.example.wtest.persistence.db.AddressDao
import com.example.wtest.web.ws.ContentWebservice
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AddressRepository @Inject constructor(
    private val webservice: ContentWebservice,
    private val dao: AddressDao,
    val addressList: LiveData<List<Address>>
) {

}