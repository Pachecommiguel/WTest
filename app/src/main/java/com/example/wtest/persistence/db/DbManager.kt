package com.example.wtest.persistence.db

import com.example.wtest.persistence.entities.Address
import javax.inject.Inject

class DbManager @Inject constructor(
    val dao: AddressDao
) {
    fun insert(address: List<String>?) {
        dao.insert(Address(address?.get(0), address?.get(1), address?.get(2)))
    }
}