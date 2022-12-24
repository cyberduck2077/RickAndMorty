package com.example.kubsaunews.data.storage.sourse

import com.example.kubsaunews.data.storage.models.CharacterPageModel
import com.example.kubsaunews.data.storage.models.DataCharacterModel
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface ServiceCharactersAPI {
    @GET("character")
    suspend fun getCharactersInPage(@Query("page") page: String): CharacterPageModel

    @GET("character/{id_}")
    suspend fun getDetails(@Path("id_") id: Int): DataCharacterModel

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