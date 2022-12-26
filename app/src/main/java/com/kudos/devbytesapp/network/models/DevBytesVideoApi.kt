package com.kudos.devbytesapp.network.models

data class DevBytesVideoApi(
    val title: String,
    val description: String,
    val url: String,
    val updated: String,
    val thumbnail: String,
    val closedCaptions: String?
)
