package com.example.newsapi.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {
    @GET("top-headlines")
    suspend fun getTopHeadlines(
        @Query("apiKey") apiKey: String,
        @Query("country") country: String
    ): NewsApiResponse
    companion object {
        var newsApiService: NewsApiService? = null
        fun getInstance(): NewsApiService {
            if(newsApiService == null) {
                newsApiService = Retrofit.Builder()
                    .baseUrl("https://newsapi.org/v2/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(NewsApiService::class.java)
            }
            return newsApiService!!
        }
    }
}