package com.example.kubsaunews.data.storage.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DataForDbModel(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "created") var created: String = "No data",
    @ColumnInfo(name = "gender") var gender: String = "No data",
    @ColumnInfo(name = "id_in_server") var id_in_server: String = "No data",
    @ColumnInfo(name = "image") var image: String = "No data",
    @ColumnInfo(name = "location") var location: String = "No data",
    @ColumnInfo(name = "name") var name: String = "No data",
    @ColumnInfo(name = "origin_name") var origin_name: String = "No data",
    @ColumnInfo(name = "origin_url") var origin_url: String = "No data",
    @ColumnInfo(name = "species") var species: String = "No data",
    @ColumnInfo(name = "status") var status: String = "No data",
    @ColumnInfo(name = "type") var type: String = "No data",
    @ColumnInfo(name = "url") var url: String = "No data",
    @ColumnInfo(name = "episode") var episode: List<String> = listOf("No data"),
)