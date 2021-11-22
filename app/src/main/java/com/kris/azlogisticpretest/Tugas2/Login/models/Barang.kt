package com.kris.azlogisticpretest.Tugas2.Login.models

data class Barang (
    val database: List<Database>
    ){
    data class Database(
        val albumId: Int,
        val id: Int,
        val thumbnailUrl: String,
        val title: String,
        val url: String
    )
}
