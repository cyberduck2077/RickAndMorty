package com.example.kubsaunews.di

import com.example.kubsaunews.domain.usecases.details.GetDetailsUseCase
import com.example.kubsaunews.domain.usecases.details.SaveDataUseCase
import com.example.kubsaunews.domain.usecases.saveddata.DeleteDataUseCase
import com.example.kubsaunews.domain.usecases.saveddata.GetAllDataFromDbUseCase
import com.example.kubsaunews.domain.usecases.start.GetCharactersListByPageUseCase
import org.koin.dsl.module

val domainModule = module{

    factory<GetCharactersListByPageUseCase>{
        GetCharactersListByPageUseCase(repository = get())
    }
    factory<DeleteDataUseCase> {
        DeleteDataUseCase(repository = get())
    }
    factory<GetAllDataFromDbUseCase> {
        GetAllDataFromDbUseCase(repository = get())
    }
    factory <GetDetailsUseCase>{
        GetDetailsUseCase(repository = get())
    }
    factory<SaveDataUseCase> {
        SaveDataUseCase(repository = get())
    }
}