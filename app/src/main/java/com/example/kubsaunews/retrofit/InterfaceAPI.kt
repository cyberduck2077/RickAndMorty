package com.example.kubsaunews.retrofit

import com.example.kubsaunews.data.CharacterData
import com.example.kubsaunews.data.Result
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path


interface InterfaceAPI {
    @GET("character")
    fun getUser(): Call<CharacterData>

    @GET("character/{id_}")
    fun getDetails(@Path("id_")id:Int):Call<Result>

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