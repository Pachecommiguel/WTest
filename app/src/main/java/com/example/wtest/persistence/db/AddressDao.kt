package com.example.wtest.persistence.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.wtest.persistence.entities.Address

@Dao
interface AddressDao {

    @Query("SELECT * FROM Address")
    fun getAll(): LiveData<List<Address>>

    @Insert
    fun insertAll(address: List<Address>)
}