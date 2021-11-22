package com.kris.azlogisticpretest.Tugas2.Login.models

class info : ArrayList<infoItem>()

data class infoItem(
    val albumId: Int,
    val id: Int,
    val thumbnailUrl: String,
    val title: String,
    val url: String
)