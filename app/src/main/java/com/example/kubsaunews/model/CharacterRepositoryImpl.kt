package com.example.kubsaunews.model

import com.example.kubsaunews.data.CharacterData
import com.example.kubsaunews.data.Result
import com.example.kubsaunews.retrofit.InterfaceAPI
import retrofit2.Call

class CharacterRepositoryImpl:CharacterRepository {

    val interfaceAPI:InterfaceAPI = InterfaceAPI.create()

    override fun getCharacters(): Call<CharacterData> {
       return interfaceAPI.getCharacters()
    }

    override fun getDetails(id:Int): Call<Result> {
        return interfaceAPI.getDetails(id)
    }
}