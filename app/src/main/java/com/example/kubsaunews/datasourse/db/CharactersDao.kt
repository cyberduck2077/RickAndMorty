package com.example.kubsaunews.datasourse.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CharactersDao {
    @Query("select * from DataForDb")
    suspend fun loadAllFromDb():List<DataForDb>

    @Insert
    suspend fun insertCharacter(character:DataForDb)

    @Delete
    suspend fun deleteCharacter(character:DataForDb)
}