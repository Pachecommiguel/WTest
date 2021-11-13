package com.example.wtest.persistence.db

import javax.inject.Inject

class DbManager @Inject constructor(
    val dao: AddressDao
) {

}