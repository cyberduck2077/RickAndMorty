package com.example.kubsaunews.data.storage.characterdata

import android.util.Log
import com.example.kubsaunews.data.storage.models.CharacterPageModel
import com.example.kubsaunews.data.storage.models.DataCharacterModel
import com.example.kubsaunews.data.storage.sourse.ServiceCharactersAPI

class CharacterDataImpl : CharacterData {


//    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
//        throwable.printStackTrace()
//    }

    override suspend fun getCharacterPage(page: Int): CharacterPageModel {
        Log.d("Response", "start")
        val response = ServiceCharactersAPI.create().getCharactersInPage(page = page.toString())
        Log.d("Response", "${response}")
        return response
    }

    override suspend fun getCharacterById(id: Int): DataCharacterModel {
        val response = ServiceCharactersAPI.create().getDetails(id = id)
        return response

    }

}