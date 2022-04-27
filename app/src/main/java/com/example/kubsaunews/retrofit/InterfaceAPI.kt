package com.example.kubsaunews.retrofit

import com.example.kubsaunews.data.CharacterData
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


interface InterfaceAPI {
    @GET("character")
    fun getUser(): Call<CharacterData>

    companion object {

        private var BASE_URL = "https://rickandmortyapi.com/api/"

        fun create(): InterfaceAPI {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .client(UnsafeOkHttpClient.getUnsafeOkHttpClient().build())
                .build()
            return retrofit.create(InterfaceAPI::class.java)

        }

    }
}