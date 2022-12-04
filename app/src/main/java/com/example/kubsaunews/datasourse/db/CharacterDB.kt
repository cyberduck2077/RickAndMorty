package com.example.kubsaunews.datasourse.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [DataForDb::class], version = 1)
@TypeConverters(EpisodeConverter::class)
abstract class CharacterDB : RoomDatabase() {
    abstract fun charactersDao(): CharactersDao


    companion object {
        private var db: CharacterDB? = null

        @Synchronized
        fun getInstance(context: Context): CharacterDB {
            return if (db == null) {
                db = Room.databaseBuilder(context, CharacterDB::class.java, "db").build()
                db as CharacterDB
            } else {
                db as CharacterDB
            }
        }
    }

}