package com.example.wtest.di.modules

import com.example.wtest.web.RetrofitApp
import com.example.wtest.web.ws.ContentWebservice
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ContentWebserviceModule {

    @Singleton
    @Provides
    fun provideContentWebservice(): ContentWebservice = RetrofitApp.getInstance()
        .create(ContentWebservice::class.java)
}