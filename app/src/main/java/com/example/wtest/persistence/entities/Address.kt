package com.example.wtest.persistence.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Address(
    @PrimaryKey(autoGenerate = true)
    var key: Int,
    var zipCode: String,
    var location: String
)
