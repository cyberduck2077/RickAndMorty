package com.example.kubsaunews.domain.usecases.details

import com.example.kubsaunews.domain.models.CharacterModel
import com.example.kubsaunews.domain.repositories.DetailsRepository
import com.example.kubsaunews.domain.usecases.base.UseCase

class SaveDataUseCase(private val repository: DetailsRepository):UseCase<Boolean, CharacterModel>() {

//    suspend fun execute(model: CharacterModel): Boolean {
//
//        return repository.saveData(data = model)
//    }

    override suspend fun buildUseCase(params: CharacterModel): Boolean {
        return repository.saveData(data = params)
    }

    override val reportUseCaseName: String
        get() = "Save Data UseCase"
}