package com.example.kubsaunews.domain.usecases.saveddata

import android.util.Log
import com.example.kubsaunews.domain.models.CharacterModel
import com.example.kubsaunews.domain.repositories.SavedDataRepository
import com.example.kubsaunews.domain.usecases.base.UseCase

class GetAllDataFromDbUseCase(private val repository: SavedDataRepository):UseCase<List<CharacterModel>,UseCase.None>() {

//    suspend fun execute():List<CharacterModel>{
//
//        return repository.getAllDataFromDb()
//    }

    override suspend fun buildUseCase(params: None): List<CharacterModel> {
        val res = repository.getAllDataFromDb()
        Log.d("TTTTTTTTTTTTTTTTT", "\n${res[0].name}\n${res[0].gender}")
        return res
    }

    override val reportUseCaseName: String
        get() = "Get All Data From Db UseCase"
}