package com.kudos.devbytesapp.di

import com.kudos.devbytesapp.db.dao.DevBytesDao
import com.kudos.devbytesapp.network.service.DevBytesApiService
import com.kudos.devbytesapp.repository.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideMainRepository(devBytesApiService: DevBytesApiService,devBytesDao: DevBytesDao): MainRepository {
        return MainRepository(devBytesApiService,devBytesDao)
    }

}