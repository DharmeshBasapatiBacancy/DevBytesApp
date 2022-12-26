package com.kudos.devbytesapp.utils

import com.kudos.devbytesapp.db.entities.DevBytesVideoDB
import com.kudos.devbytesapp.domain.DevByteVideo
import com.kudos.devbytesapp.network.models.DevBytesApiResponse

fun List<DevBytesVideoDB>.asDomainModel(): List<DevByteVideo> {
    return map {
        DevByteVideo(
            url = it.url,
            title = it.title,
            description = it.description,
            updated = it.updated,
            thumbnail = it.thumbnail
        )
    }
}

/**
 * Convert Network results to database objects
 */
fun DevBytesApiResponse.asDomainModel(): List<DevByteVideo> {
    return videos.map {
        DevByteVideo(
            title = it.title,
            description = it.description,
            url = it.url,
            updated = it.updated,
            thumbnail = it.thumbnail
        )
    }
}


/**
 * Convert Network results to database objects
 */
fun DevBytesApiResponse.asDatabaseModel(): List<DevBytesVideoDB> {
    return videos.map {
        DevBytesVideoDB(
            title = it.title,
            description = it.description,
            url = it.url,
            updated = it.updated,
            thumbnail = it.thumbnail
        )
    }
}