package com.example.kennyobey.newsonsports

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Client {
    companion object {
    //base url
        private const val baseURL = "http://www.newsapi.org/v2/"
        fun getRetrofit () : Retrofit {
            //initialize retrofit with the  base url and gson converter
            return Retrofit.Builder().baseUrl(baseURL).addConverterFactory(GsonConverterFactory.create()).build()
//https://newsapi.org/v2/top-headlines?country=us&category=sports&apiKey=0adf070657ca4ef4b089c47f2e218e31
            // 0adf070657ca4ef4b089c47f2e218e31
        }
    }
}