package com.kudos.devbytesapp.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kudos.devbytesapp.db.dao.DevBytesDao
import com.kudos.devbytesapp.db.entities.DevBytesVideoDB

@Database(entities = [DevBytesVideoDB::class], exportSchema = false, version = 1)
abstract class DevBytesDatabase : RoomDatabase() {

    abstract fun devBytesDao(): DevBytesDao

}