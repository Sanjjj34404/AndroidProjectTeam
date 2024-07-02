package com.example.recipeapp.Api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    companion object{
        fun getClient():Retrofit{
            return Retrofit.Builder()
                    .baseUrl("https://api.edamam.com/")
                    .addConverterFactory(GsonConverterFactory.create()).build()
        }
    }
}