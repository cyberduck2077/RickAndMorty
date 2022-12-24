package com.example.kubsaunews.domain.repositories

import com.example.kubsaunews.domain.models.CharacterModel

interface DetailsRepository {
    suspend fun saveData(data: CharacterModel): Boolean

    suspend fun getDetails(id: Int): CharacterModel
}