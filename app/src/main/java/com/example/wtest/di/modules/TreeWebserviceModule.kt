package com.example.wtest.di.modules

import com.example.wtest.web.RetrofitApp
import com.example.wtest.web.ws.TreeWebservice
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TreeWebserviceModule {

    @Singleton
    @Provides
    fun provideTreeWebservice(): TreeWebservice = RetrofitApp.getInstance()
        .create(TreeWebservice::class.java)
}