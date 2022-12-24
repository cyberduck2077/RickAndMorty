package com.example.kubsaunews.presentation.saveddata

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kubsaunews.data.repository.SavedDataRepositoryImpl
import com.example.kubsaunews.domain.models.CharacterModel
import com.example.kubsaunews.domain.usecases.base.UseCase
import com.example.kubsaunews.domain.usecases.saveddata.DeleteDataUseCase
import com.example.kubsaunews.domain.usecases.saveddata.GetAllDataFromDbUseCase
import kotlinx.coroutines.*

class SavedDataViewModel(application: Application) : AndroidViewModel(application) {

    private val _liveDataListSavedData = MutableLiveData<List<CharacterModel>>()
    val liveDataListSavedData: LiveData<List<CharacterModel>> = _liveDataListSavedData
    private val _isSuccessDelete = MutableLiveData<Boolean>()
    val isSuccessDelete:LiveData<Boolean> = _isSuccessDelete

    var jobLoadAll: Job? = null
    var jobDeleteData: Job? = null

    private val repository =
        com.example.kubsaunews.data.repository.SavedDataRepositoryImpl(application)

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
                    _isSuccessDelete.postValue(true)
                },
                onError = {
                    _isSuccessDelete.postValue(false)
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