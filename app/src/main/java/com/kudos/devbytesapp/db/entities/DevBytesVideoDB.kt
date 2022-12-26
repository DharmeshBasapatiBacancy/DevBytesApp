package com.kudos.devbytesapp.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "devBytesVideo")
data class DevBytesVideoDB(
    @PrimaryKey
    val url: String,
    val updated: String,
    val title: String,
    val description: String,
    val thumbnail: String
)
