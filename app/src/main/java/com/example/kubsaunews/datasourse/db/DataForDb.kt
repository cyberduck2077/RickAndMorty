package com.example.kubsaunews.datasourse.db

import androidx.room.*

@Entity
data class DataForDb(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,

    @ColumnInfo(name = "created") val created: String = "No data",

    @ColumnInfo(name = "episode") val episode: List<String?> = emptyList<String>(),

    @ColumnInfo(name = "gender") val gender: String = "No data",

    @ColumnInfo(name = "id_in_server") val id_in_server: String = "No data",

    @ColumnInfo(name = "image") val image: String = "No data",

    @ColumnInfo(name = "location") val location: String = "No data",

    @ColumnInfo(name = "name") val name: String = "No data",

    @ColumnInfo(name = "origin_name") val origin_name: String = "No data",

    @ColumnInfo(name = "origin_url") val origin_url: String = "No data",

    @ColumnInfo(name = "species") val species: String = "No data",

    @ColumnInfo(name = "status") val status: String = "No data",

    @ColumnInfo(name = "type") val type: String = "No data",

    @ColumnInfo(name = "url") val url: String = "No data",
)

//data class Location(
//    val name: String?,
//    val url: String?
//)
//
//data class Origin(
//    val name: String?,
//    val url: String?
//)