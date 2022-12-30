package com.example.kubsaunews.presentation.start

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kubsaunews.domain.models.CharacterModel
import com.example.kubsaunews.domain.repositories.CharacterListRepository
import com.example.kubsaunews.domain.usecases.start.GetCharactersListByPageUseCase
import kotlinx.coroutines.Job
import kotlinx.coroutines.MainScope

class MainActivityViewModel(application: Application, private val repository: CharacterListRepository) : AndroidViewModel(application) {

    private val _characters = MutableLiveData<List<CharacterModel>>()
    val characters: LiveData<List<CharacterModel>> = _characters




    private var job: Job? = null
    val currentPage = MutableLiveData<Int>().apply {
        value = 1
    }


    init {
        getCharacterList()
    }


    fun getCharacterList() {
        GetCharactersListByPageUseCase(repository).execute(
            params = currentPage.value!!,
            scope = MainScope(),
            onSuccess = {
                _characters.postValue(it)
            },
            onError = {
                Log.d("error", "error")
            }

        )
    }


    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}
