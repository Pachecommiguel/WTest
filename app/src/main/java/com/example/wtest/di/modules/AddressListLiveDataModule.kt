package com.example.wtest.di.modules

import androidx.lifecycle.LiveData
import com.example.wtest.persistence.entities.Address
import com.example.wtest.persistence.db.AddressDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AddressListLiveDataModule {

    @Singleton
    @Provides
    fun provideAddressListLiveData(dao: AddressDao): LiveData<List<Address>> = dao.getAll()
}