package com.example.kennyobey.newsonsports

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Apiinterface {

    //specify the endpoint to get popular movies from
    @GET("top-headlines")
    fun getLatestnews(@Query("apiKey") apiKey :String,
                         @Query("country") country : String,
                         @Query("category") category: String) : Call<NewsFetch>
}