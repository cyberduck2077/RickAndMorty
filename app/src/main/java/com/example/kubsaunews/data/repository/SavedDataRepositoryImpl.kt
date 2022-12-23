package com.example.kubsaunews.data.repository

import android.content.Context
import android.util.Log
import com.example.kubsaunews.data.storage.datafordb.DataForDbImpl
import com.example.kubsaunews.data.storage.models.DataForDbModel
import com.example.kubsaunews.domain.models.CharacterModel
import com.example.kubsaunews.domain.repositories.SavedDataRepository

class SavedDataRepositoryImpl(private val context: Context) : SavedDataRepository {

    val db = DataForDbImpl(context)


    override suspend fun getAllDataFromDb(): List<CharacterModel> {


        val dbList = db.loadAllFromDb()
        val resultList = mutableListOf<CharacterModel>()

        dbList.forEach {
            resultList.add(
                CharacterModel(
                    created = it.created,
                    episode = it.episode,
                    gender = it.gender,
                    id = it.id_in_server.toInt(),
                    image = it.image,
                    name = it.name,
                    species = it.species,
                    status = it.status,
                    type = it.type,
                    url = it.url,
                    origin_name = it.origin_name,
                    origin_url = it.origin_url,
                    location_name = it.location,
                    location_url = "No data",//add location_url in model
                )
            )
        }

        return resultList as List<CharacterModel>

    }

    override suspend fun deleteData(data: CharacterModel): Boolean {
        try {

            var model: DataForDbModel
            data.apply {
                model = DataForDbModel(
                    created = this.created,
                    gender = this.gender,
                    id_in_server = this.id.toString(),
                    image = this.image,
                    location = this.location_name,
                    name = this.name,
                    origin_name = this.origin_name,
                    origin_url = this.origin_url,
                    species = this.species,
                    status = this.status,
                    type = this.status,
                    url = this.url,
                    episode = this.episode

                )
            }
            db.deleteCharacter(model)

            return true

        } catch (e: Exception) {
            return false
        }
    }
}