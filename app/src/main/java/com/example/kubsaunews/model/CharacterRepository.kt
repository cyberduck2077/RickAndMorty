package com.example.kubsaunews.model

import com.example.kubsaunews.data.CharacterData
import com.example.kubsaunews.data.Result
import retrofit2.Call

interface CharacterRepository {
   fun getCharacters():Call<CharacterData>

   fun getDetails(id:Int):Call<Result>
}