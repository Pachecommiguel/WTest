package com.example.wtest.di.modules

import com.example.wtest.persistence.db.AddressDao
import com.example.wtest.persistence.db.RoomApp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AddressDaoModule {

    @Singleton
    @Provides
    fun provideAddressDao(roomApp: RoomApp): AddressDao {
        return roomApp.AddressDao()
    }
}