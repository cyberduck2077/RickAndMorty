package com.example.kubsaunews.data.repository

import android.content.Context
import android.util.Log
import com.example.kubsaunews.data.storage.characterdata.CharacterDataImpl
import com.example.kubsaunews.data.storage.datafordb.DataForDbImpl
import com.example.kubsaunews.data.storage.models.DataForDbModel
import com.example.kubsaunews.domain.models.CharacterModel
import com.example.kubsaunews.domain.repositories.DetailsRepository

class DetailsRepositoryImpl(private val context: Context) : DetailsRepository {
    override suspend fun saveData(data: CharacterModel): Boolean {

        try {
            val d: DataForDbModel = DataForDbModel().also {
                it.created = data.created
                it.episode = data.episode
                it.gender = data.gender
                it.id_in_server = data.id.toString()
                it.image = data.image
                it.location = data.location_name
                it.name = data.name
                it.origin_name = data.origin_name
                it.origin_url = data.origin_url
                it.species = data.species
                it.status = data.status
                it.type = data.type
                it.url = data.url
            }


            DataForDbImpl(context).insertCharacter(d)

            Log.d("DATA", "SaveData: Success")

            return true
        } catch (e: Exception) {
            Log.d("DATA", "SaveData Failure: ${e.toString()}")
            return false
        }


    }

    override suspend fun getDetails(id: Int): CharacterModel {

        val ch = CharacterDataImpl().getCharacterById(id = id)

        return CharacterModel().also {
            it.created = ch.created!!
            it.episode = ch.episode as List<String>
            it.gender = ch.gender!!
            it.id = ch.id!!
            it.image = ch.image!!
            it.name = ch.name!!
            it.species = ch.species!!
            it.status = ch.status!!
            it.type = ch.type!!
            it.url = ch.url!!
            it.origin_name = ch.origin!!.name!!
            it.origin_url = ch.origin.url!!
            it.location_name = ch.location!!.name!!
            it.location_url = ch.location.url!!
        }
    }
}