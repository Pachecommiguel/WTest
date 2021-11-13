package com.example.wtest.persistence.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Address(
    var fourDigits: String?,
    var threeDigits: String?,
    var location: String?
) {
    @PrimaryKey(autoGenerate = true)
    var key: Int = 0
}
