package com.example.kubsaunews.data.storage.sourse.db

import androidx.room.TypeConverter
import com.google.gson.Gson


class EpisodeConverter {

//    @TypeConverter
//    fun fromEpisodeList(episodes: List<String>): String {
//        val gson = Gson()
//        return gson.toJson(episodes)
//    }
//
//    @TypeConverter
//    fun toEpisodeList(episodes:String):List<String>{
//        val listType: Type = object : TypeToken<ArrayList<String?>?>() {}.type
//        return Gson().fromJson(episodes, listType)
//    }
    @TypeConverter
    fun listToJson(value: List<String>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToList(value: String) = Gson().fromJson(value, Array<String>::class.java).toList()
}