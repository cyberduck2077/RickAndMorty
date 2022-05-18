package com.example.kubsaunews.modelview

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kubsaunews.data.CharacterData
import com.example.kubsaunews.model.CharacterRepository
import com.example.kubsaunews.model.CharacterRepositoryImpl
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CharacterDataModelView {

    private val _characters = MutableLiveData<CharacterData>()
    val characters:LiveData<CharacterData> = _characters

    private val mCharacterRepository: CharacterRepository = CharacterRepositoryImpl()

    fun getCharacters(){
        val response = mCharacterRepository.getCharacters()

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
