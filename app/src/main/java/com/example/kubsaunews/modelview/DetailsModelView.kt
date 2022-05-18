package com.example.kubsaunews.modelview

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kubsaunews.data.Result
import com.example.kubsaunews.model.CharacterRepository
import com.example.kubsaunews.model.CharacterRepositoryImpl
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailsModelView {

    private val _details = MutableLiveData<Result>()
    val details: LiveData<Result> = _details

    private val mCharacterRepository: CharacterRepository = CharacterRepositoryImpl()

    fun getDetails(id: Int){
        val response = mCharacterRepository.getDetails(id)

        response.enqueue( object : Callback<Result> {
            override fun onResponse(call: Call<Result>, response: Response<Result>) {
                _details.postValue(response.body())
            }

            override fun onFailure(call: Call<Result>, t: Throwable) {
                Log.d("TTT","onFailure : ${t.message}")
            }


        })
    }
}