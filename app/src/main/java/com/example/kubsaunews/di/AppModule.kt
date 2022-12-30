package com.example.kubsaunews.di

import com.example.kubsaunews.presentation.details.DetailsActivityViewModel
import com.example.kubsaunews.presentation.saveddata.SavedDataViewModel
import com.example.kubsaunews.presentation.start.MainActivityViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel<MainActivityViewModel> {
        MainActivityViewModel(
            application = get(),
            repository = get() //CharacterListRepository
        )
    }
    viewModel<SavedDataViewModel> {
        SavedDataViewModel(
            application = get(),
            repository = get()//SavedDataRepository

        )
    }
    viewModel<DetailsActivityViewModel> {
        DetailsActivityViewModel(
            application = get(),
            repository = get()//DetailsRepository

        )
    }
}