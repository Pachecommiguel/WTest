package com.example.wtest.persistence.db

import com.example.wtest.persistence.entities.Address
import javax.inject.Inject

class DbManager @Inject constructor(
    val dao: AddressDao
) {

    fun insertAll(list: List<List<String>?>) {
        dao.insertAll(
            list.map {
                Address(it?.get(0), it?.get(1), it?.get(2))
            }
        )
    }
}