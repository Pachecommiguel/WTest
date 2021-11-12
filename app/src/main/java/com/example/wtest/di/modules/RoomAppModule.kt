package com.example.wtest.di.modules

import android.content.Context
import androidx.room.Room
import com.example.wtest.persistence.db.RoomApp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomAppModule {

    @Singleton
    @Provides
    fun provideRoomApp(@ApplicationContext context: Context): RoomApp {
        return Room.databaseBuilder(context, RoomApp::class.java, RoomApp.DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }
}