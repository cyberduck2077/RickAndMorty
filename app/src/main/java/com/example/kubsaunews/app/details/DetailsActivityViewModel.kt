package com.example.kubsaunews.app.details

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kubsaunews.data.repository.DetailsRepositoryImpl
import com.example.kubsaunews.domain.models.CharacterModel
import com.example.kubsaunews.domain.usecases.details.GetDetailsUseCase
import com.example.kubsaunews.domain.usecases.details.SaveDataUseCase
import kotlinx.coroutines.*

class DetailsActivityViewModel(application: Application) :AndroidViewModel(application) {

    private val _details = MutableLiveData<CharacterModel>()
    val details: LiveData<CharacterModel> = _details

    private var job: Job? = null

    var jobSentData: Job? = null

    private val repository = DetailsRepositoryImpl(application)

    fun getDetails(id: Int){

        job = CoroutineScope(Dispatchers.IO).launch {
            GetDetailsUseCase(repository).execute(
                params = id,
                scope = MainScope(),
                onSuccess = {
                    _details.postValue(it)
                },
                onError = {
                    Log.d("Get Details", "error")
                }

            )
        }
    }

    fun saveData(model: CharacterModel){
        jobSentData = CoroutineScope(Dispatchers.IO).launch {

            SaveDataUseCase(repository).execute(
                params = model,
                scope = MainScope(),
                onSuccess = {
                    Log.d("Save Data", it.toString())
                },
                onError = {
                    Log.d("Save Data", "error")
                }

            )
        }
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
        jobSentData?.cancel()
    }
}