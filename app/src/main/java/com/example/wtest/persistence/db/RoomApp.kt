package com.example.wtest.persistence.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.wtest.persistence.entities.Address

@Database(entities = [Address::class], version = 1, exportSchema = false)
abstract class RoomApp : RoomDatabase() {
    abstract fun AddressDao(): AddressDao

    companion object {
        const val DATABASE_NAME = "address-db"
    }
}