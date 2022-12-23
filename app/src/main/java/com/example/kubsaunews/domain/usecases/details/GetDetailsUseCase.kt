package com.example.kubsaunews.domain.usecases.details

import com.example.kubsaunews.domain.models.CharacterModel
import com.example.kubsaunews.domain.repositories.DetailsRepository
import com.example.kubsaunews.domain.usecases.base.UseCase

class GetDetailsUseCase(private val repository: DetailsRepository):UseCase<CharacterModel, Int>() {

//    suspend fun execute(id: Int): CharacterModel {
//
//        return repository.getDetails(id = id)
//    }


    override suspend fun buildUseCase(params: Int): CharacterModel {
        return repository.getDetails(id = params)
    }

    override val reportUseCaseName: String
        get() = "Get Details UseCase"
}