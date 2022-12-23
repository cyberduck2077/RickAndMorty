package com.example.kubsaunews.data.repository

import com.example.kubsaunews.data.storage.characterdata.CharacterDataImpl
import com.example.kubsaunews.domain.models.CharacterModel
import com.example.kubsaunews.domain.repositories.CharacterListRepository

class CharacterListRepositoryImpl : CharacterListRepository {
    override suspend fun getCharacterListByPage(page: Int): List<CharacterModel> {


        val page = CharacterDataImpl().getCharacterPage(page = page)

        val mutableList = emptyList<CharacterModel>().toMutableList()

        page.results!!.forEach {
            mutableList.add(CharacterModel().apply {
                this.id = it?.id ?: 0
                this.created = it?.created ?: "no data"
                this.episode = it?.episode as List<String>
                this.gender = it.gender ?: "no data"
                this.image = it.image ?: "no data"
                this.name = it.name ?: "no data"
                this.species = it.species ?: "no data"
                this.status = it.status ?: "no data"
                this.type = it.type ?: "no data"
                this.url = it.url ?: "no data"
                this.origin_name = it.origin?.name ?: "no data"
                this.origin_url = it.origin?.url ?: "no data"
                this.location_name = it.location?.name ?: "no data"
                this.location_url = it.location?.url ?: "no data"
            })
        }


        return mutableList as List<CharacterModel>

    }
}