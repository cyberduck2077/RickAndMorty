package com.example.kubsaunews.presentation.saveddata

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kubsaunews.domain.models.CharacterModel
import com.example.kubsaunews.domain.repositories.SavedDataRepository
import com.example.kubsaunews.domain.usecases.base.UseCase
import com.example.kubsaunews.domain.usecases.saveddata.DeleteDataUseCase
import com.example.kubsaunews.domain.usecases.saveddata.GetAllDataFromDbUseCase
import kotlinx.coroutines.*

class SavedDataViewModel(application: Application, private val repository: SavedDataRepository) :
    AndroidViewModel(application) {

    private val _liveDataListSavedData = MutableLiveData<List<CharacterModel>>()
    val liveDataListSavedData: LiveData<List<CharacterModel>> = _liveDataListSavedData

    var jobLoadAll: Job? = null
    var jobDeleteData: Job? = null

    fun getAllDataFromDb() {
        jobLoadAll = CoroutineScope(Dispatchers.IO).launch {
            GetAllDataFromDbUseCase(repository).execute(
                params = UseCase.None(),
                scope = MainScope(),
                onSuccess = {
                    _liveDataListSavedData.postValue(it)
                },
                onError = {
                    Log.d("GetAllDataFromDb", "error")
                }

            )
        }
    }

    fun deleteData(d: CharacterModel) {
        jobDeleteData = CoroutineScope(Dispatchers.IO).launch {
            DeleteDataUseCase(repository).execute(
                params = d,
                scope = MainScope(),
                onSuccess = {
                    Log.d("Delete Data", it.toString())

                },
                onError = {

                    Log.d("Delete Data", "error")
                },

                )
        }
    }


    override fun onCleared() {
        super.onCleared()

        jobLoadAll?.cancel()
        jobDeleteData?.cancel()
    }
}