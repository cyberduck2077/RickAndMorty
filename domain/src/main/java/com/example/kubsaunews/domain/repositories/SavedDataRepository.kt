package com.example.kubsaunews.domain.repositories

import com.example.kubsaunews.domain.models.CharacterModel

interface SavedDataRepository {
    suspend fun getAllDataFromDb():List<CharacterModel>

    suspend fun deleteData(data:CharacterModel):Boolean
}