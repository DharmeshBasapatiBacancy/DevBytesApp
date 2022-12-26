package com.kudos.devbytesapp.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kudos.devbytesapp.db.entities.DevBytesVideoDB

@Dao
interface DevBytesDao {

    @Query("select * from devBytesVideo")
    fun getVideos(): LiveData<List<DevBytesVideoDB>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll( videos: List<DevBytesVideoDB>)

}