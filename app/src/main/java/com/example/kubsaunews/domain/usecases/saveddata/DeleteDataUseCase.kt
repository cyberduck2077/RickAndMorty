package com.example.kubsaunews.domain.usecases.saveddata

import android.util.Log
import com.example.kubsaunews.domain.models.CharacterModel
import com.example.kubsaunews.domain.repositories.SavedDataRepository
import com.example.kubsaunews.domain.usecases.base.UseCase

class DeleteDataUseCase(private val repository: SavedDataRepository): UseCase<Boolean, CharacterModel>() {

//    suspend fun execute(data:CharacterModel):Boolean{
//
//        return repository.deleteData(data = data)
//    }

    override suspend fun buildUseCase(params: CharacterModel): Boolean {
        val res = repository.deleteData(data = params)
        Log.d("DELETE DATA", "$res")
        return res
    }

    override val reportUseCaseName: String
        get() = "Delete Data UseCase"
}