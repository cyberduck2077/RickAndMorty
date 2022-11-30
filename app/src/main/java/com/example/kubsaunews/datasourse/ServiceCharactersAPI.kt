package com.example.kubsaunews.datasourse

import com.example.kubsaunews.models.CharacterData
import com.example.kubsaunews.models.Result
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface ServiceCharactersAPI {
    @GET("character")
    fun getCharactersInPage(@Query("page")page:String): Call<CharacterData>

    @GET("character/{id_}")
    fun getDetails(@Path("id_")id:Int):Call<Result>

    companion object {


        private var BASE_URL = "https://rickandmortyapi.com/api/"

        fun create(): ServiceCharactersAPI {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ServiceCharactersAPI::class.java)

        }

    }
}