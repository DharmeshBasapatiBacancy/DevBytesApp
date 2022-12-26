package com.kudos.devbytesapp.network.service

import com.kudos.devbytesapp.network.models.DevBytesApiResponse
import retrofit2.http.GET

interface DevBytesApiService {

    @GET("devbytes")
    suspend fun getPlaylist(): DevBytesApiResponse

}