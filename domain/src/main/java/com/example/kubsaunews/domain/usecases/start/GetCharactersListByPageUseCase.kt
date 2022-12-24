package com.example.kubsaunews.domain.usecases.start

import com.example.kubsaunews.domain.models.CharacterModel
import com.example.kubsaunews.domain.repositories.CharacterListRepository
import com.example.kubsaunews.domain.usecases.base.UseCase

class GetCharactersListByPageUseCase(private val repository: CharacterListRepository):
    UseCase<List<CharacterModel>, Int>() {

//    suspend fun execute(page: Int): List<CharacterModel> {
//        CoroutineScope(Dispatchers.Main).launch {
//            val res = withContext(Dispatchers.IO) {  }
//
//        }
//    }



    override suspend fun buildUseCase(params: Int): List<CharacterModel> {
        return repository.getCharacterListByPage(page = params)
    }

    override val reportUseCaseName: String
        get() = "Get Character UseCase"
}