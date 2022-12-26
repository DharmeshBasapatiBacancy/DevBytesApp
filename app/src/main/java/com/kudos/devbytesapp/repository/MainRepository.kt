package com.kudos.devbytesapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.kudos.devbytesapp.db.dao.DevBytesDao
import com.kudos.devbytesapp.domain.DevByteVideo
import com.kudos.devbytesapp.network.service.DevBytesApiService
import com.kudos.devbytesapp.utils.asDatabaseModel
import com.kudos.devbytesapp.utils.asDomainModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val devBytesApiService: DevBytesApiService,
    private val devBytesDao: DevBytesDao
) {

    suspend fun refreshVideos() {
        withContext(Dispatchers.IO) {
            val playlist = devBytesApiService.getPlaylist()
            devBytesDao.insertAll(playlist.asDatabaseModel())
        }
    }

    val videos: LiveData<List<DevByteVideo>> = Transformations.map(devBytesDao.getVideos()) {
        it.asDomainModel()
    }

}