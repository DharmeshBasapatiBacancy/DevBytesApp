package com.kudos.devbytesapp.di

import android.content.Context
import androidx.room.Room
import com.kudos.devbytesapp.db.DevBytesDatabase
import com.kudos.devbytesapp.db.dao.DevBytesDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
private object DatabaseModule {

    @Provides
    fun provideDevBytesDao(devBytesDatabase: DevBytesDatabase): DevBytesDao {
        return devBytesDatabase.devBytesDao()
    }

    @Provides
    @Singleton
    fun provideDevBytesDatabase(
        @ApplicationContext context: Context,
    ): DevBytesDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            DevBytesDatabase::class.java,
            "DevBytesDB"
        ).build()
    }

}