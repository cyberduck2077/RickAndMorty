package com.example.kubsaunews.data.storage.characterdata

import com.example.kubsaunews.data.storage.models.CharacterPageModel
import com.example.kubsaunews.data.storage.models.DataCharacterModel
import com.example.kubsaunews.data.storage.sourse.ServiceCharactersAPI

class CharacterDataImpl : CharacterData {

    override suspend fun getCharacterPage(page: Int): CharacterPageModel {
        return ServiceCharactersAPI.create().getCharactersInPage(page = page.toString())
    }

    override suspend fun getCharacterById(id: Int): DataCharacterModel {
        return ServiceCharactersAPI.create().getDetails(id = id)

    }

}