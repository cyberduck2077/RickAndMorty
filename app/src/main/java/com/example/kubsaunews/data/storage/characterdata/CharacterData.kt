package com.example.kubsaunews.data.storage.characterdata

import com.example.kubsaunews.data.storage.models.CharacterPageModel
import com.example.kubsaunews.data.storage.models.DataCharacterModel

interface CharacterData {
   suspend fun getCharacterPage(page:Int): CharacterPageModel

   suspend fun getCharacterById(id:Int): DataCharacterModel

}