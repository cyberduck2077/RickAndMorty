package com.example.kubsaunews.domain.usecases.saveddata

import com.example.kubsaunews.domain.models.CharacterModel
import com.example.kubsaunews.domain.repositories.SavedDataRepository
import com.example.kubsaunews.domain.usecases.base.UseCase

class DeleteDataUseCase(private val repository: SavedDataRepository): UseCase<Boolean, CharacterModel>() {

//    suspend fun execute(data:CharacterModel):Boolean{
//
//        return repository.deleteData(data = data)
//    }

    override suspend fun buildUseCase(params: CharacterModel): Boolean {
        return repository.deleteData(data = params)
    }

    override val reportUseCaseName: String
        get() = "Delete Data UseCase"
}