package com.example.kubsaunews.datasourse.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


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