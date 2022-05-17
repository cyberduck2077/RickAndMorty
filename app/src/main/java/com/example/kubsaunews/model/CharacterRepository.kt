package com.example.kubsaunews.model

import com.example.kubsaunews.data.CharacterData
import retrofit2.Call

interface CharacterRepository {
   fun getCharacters():Call<CharacterData>
}