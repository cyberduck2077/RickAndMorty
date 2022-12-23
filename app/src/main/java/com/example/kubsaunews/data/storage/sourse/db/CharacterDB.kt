package com.example.kubsaunews.data.storage.sourse.db

import android.content.Context
import androidx.room.*
import com.example.kubsaunews.data.storage.datafordb.DAODataForDb
import com.example.kubsaunews.data.storage.models.DataForDbModel

@Database(
    entities = [DataForDbModel::class],
    version = 2
    //настроить миграцию
//    autoMigrations = [AutoMigration(from = 1, to = 2)],
//    exportSchema = true
)
@TypeConverters(EpisodeConverter::class)
abstract class CharacterDB : RoomDatabase() {
    abstract fun charactersDao(): DAODataForDb


    companion object {
        private var db: CharacterDB? = null

        @Synchronized
        fun getInstance(context: Context): CharacterDB {
            return if (db == null) {
                db = Room.databaseBuilder(context, CharacterDB::class.java, "db")
                    .fallbackToDestructiveMigration()
                    .build()
                db as CharacterDB
            } else {
                db as CharacterDB
            }
        }
    }

}