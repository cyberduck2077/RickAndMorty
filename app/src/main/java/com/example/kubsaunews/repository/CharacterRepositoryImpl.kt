package com.example.kubsaunews.repository

import com.example.kubsaunews.models.CharacterData
import com.example.kubsaunews.models.Result
import com.example.kubsaunews.datasourse.ServiceCharactersAPI
import retrofit2.Call

class CharacterRepositoryImpl: CharacterRepository {

    override val interfaceAPI:ServiceCharactersAPI = ServiceCharactersAPI.create()

    override fun getCharacters(page:String): Call<CharacterData> {
       return interfaceAPI.getCharactersInPage(page)
    }

    override fun getDetails(id:Int): Call<Result> {
        return interfaceAPI.getDetails(id)
    }
}