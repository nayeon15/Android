package com.example.gramo

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClinet {
    private var instance : Retrofit?=null
    private val gson = GsonBuilder().setLenient().create()

    fun  getInststnace() : Retrofit{
        if (instance == null){
            instance = Retrofit.Builder()
                .baseUrl("http://calendar/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return instance!!
    }
}