package com.example.kubsaunews.activities.details

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kubsaunews.models.Result
import com.example.kubsaunews.repository.CharacterRepository
import com.example.kubsaunews.repository.CharacterRepositoryImpl
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailsActivityViewModel(application: Application) :AndroidViewModel(application) {

    private val _details = MutableLiveData<Result>()
    val details: LiveData<Result> = _details

    private var job: Job? = null

    private val mCharacterRepository: CharacterRepository = CharacterRepositoryImpl()

    fun getDetails(id: Int){

        job = CoroutineScope(Dispatchers.IO).launch {
            val response = mCharacterRepository.getDetails(id)

            response.enqueue(object : Callback<Result> {
                override fun onResponse(call: Call<Result>, response: Response<Result>) {
                    _details.postValue(response.body())
                }

                override fun onFailure(call: Call<Result>, t: Throwable) {
                    Log.d("TTT", "onFailure : ${t.message}")
                }


            })
        }
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}