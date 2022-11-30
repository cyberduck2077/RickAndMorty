package com.example.kubsaunews.repository

import com.example.kubsaunews.models.CharacterData
import com.example.kubsaunews.models.Result
import com.example.kubsaunews.datasourse.ServiceCharactersAPI
import retrofit2.Call

interface CharacterRepository {

   val interfaceAPI: ServiceCharactersAPI

   suspend fun getCharacters(page:String):Call<CharacterData>

   suspend fun getDetails(id:Int):Call<Result>
}