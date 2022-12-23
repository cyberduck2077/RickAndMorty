package com.example.kubsaunews.domain.repositories

import com.example.kubsaunews.domain.models.CharacterModel

interface CharacterListRepository {

    suspend fun getCharacterListByPage(page:Int):List<CharacterModel>

}