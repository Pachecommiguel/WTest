package com.example.wtest.di.modules

import com.example.wtest.web.RetrofitApp
import com.example.wtest.web.ws.BlobWebservice
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object BlobWebserviceModule {

    @Singleton
    @Provides
    fun provideBlobWebservice(): BlobWebservice = RetrofitApp.getInstance()
        .create(BlobWebservice::class.java)
}