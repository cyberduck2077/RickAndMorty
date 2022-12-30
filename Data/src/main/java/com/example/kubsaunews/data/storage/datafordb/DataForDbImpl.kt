package com.example.kubsaunews.data.storage.datafordb

import android.content.Context
import com.example.kubsaunews.data.storage.models.DataForDbModel
import com.example.kubsaunews.data.storage.sourse.db.CharacterDB

class DataForDbImpl(context: Context) : DAODataForDb {

    private val db: CharacterDB = CharacterDB.getInstance(context)

    override suspend fun loadAllFromDb(): List<DataForDbModel> {
        return db.charactersDao().loadAllFromDb()
    }

    override suspend fun insertCharacter(character: DataForDbModel) {
        db.charactersDao().insertCharacter(character = character)
    }

    override suspend fun deleteCharacter(character: DataForDbModel) {
        db.charactersDao().deleteCharacter(character = character)
    }


}