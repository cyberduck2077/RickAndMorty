package com.example.kubsaunews.di

import com.example.kubsaunews.data.repository.CharacterListRepositoryImpl
import com.example.kubsaunews.data.repository.DetailsRepositoryImpl
import com.example.kubsaunews.data.repository.SavedDataRepositoryImpl
import com.example.kubsaunews.data.storage.characterdata.CharacterData
import com.example.kubsaunews.data.storage.characterdata.CharacterDataImpl
import com.example.kubsaunews.data.storage.datafordb.DAODataForDb
import com.example.kubsaunews.data.storage.datafordb.DataForDbImpl
import com.example.kubsaunews.domain.repositories.CharacterListRepository
import com.example.kubsaunews.domain.repositories.DetailsRepository
import com.example.kubsaunews.domain.repositories.SavedDataRepository
import org.koin.dsl.module

val dataModule = module {
    single<CharacterListRepository> {
        CharacterListRepositoryImpl()
    }
    single<DetailsRepository> {
        DetailsRepositoryImpl(
            context = get()
        )
    }
    single<SavedDataRepository> {
        SavedDataRepositoryImpl(
            db = get()
        )
    }
    single<CharacterData> {
        CharacterDataImpl()
    }
    single<DAODataForDb> {
        DataForDbImpl(context = get())
    }
}