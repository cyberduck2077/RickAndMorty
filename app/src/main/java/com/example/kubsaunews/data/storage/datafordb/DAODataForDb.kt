package com.example.kubsaunews.data.storage.datafordb

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.kubsaunews.data.storage.models.DataForDbModel

@Dao
interface DAODataForDb {

    @Query("select * from DataForDbModel")
    suspend fun loadAllFromDb():List<DataForDbModel>

    @Insert
    suspend fun insertCharacter(character: DataForDbModel)

    @Delete
    suspend fun deleteCharacter(character: DataForDbModel)

}