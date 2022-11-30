package com.example.kubsaunews.activities.start

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kubsaunews.models.CharacterData
import com.example.kubsaunews.repository.CharacterRepository
import com.example.kubsaunews.repository.CharacterRepositoryImpl
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {

    private val _characters = MutableLiveData<CharacterData>()
    val characters:LiveData<CharacterData> = _characters

    private val mCharacterRepository: CharacterRepository = CharacterRepositoryImpl()

     val currentPage = MutableLiveData<Int>().apply {
        value = 1
    }

    fun getCharacters(){

        val response = mCharacterRepository.getCharacters(currentPage.value.toString())

        response.enqueue( object : Callback<CharacterData> {

            override fun onResponse(call: Call<CharacterData>?, response: Response<CharacterData>?) {

                if(response?.body() != null) {
                    _characters.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<CharacterData>?, t: Throwable?) {

                Log.d("TTT","onFailure : ${t?.message}")
            }

        })
    }


}
