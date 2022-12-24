package com.example.kubsaunews.domain.usecases.saveddata

import com.example.kubsaunews.domain.models.CharacterModel
import com.example.kubsaunews.domain.repositories.SavedDataRepository
import com.example.kubsaunews.domain.usecases.base.UseCase

class GetAllDataFromDbUseCase(private val repository: SavedDataRepository):UseCase<List<CharacterModel>,UseCase.None>() {

//    suspend fun execute():List<CharacterModel>{
//
//        return repository.getAllDataFromDb()
//    }

    override suspend fun buildUseCase(params: None): List<CharacterModel> {
        return repository.getAllDataFromDb()
    }

    override val reportUseCaseName: String
        get() = "Get All Data From Db UseCase"
}