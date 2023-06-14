package com.example.newsapi.data

import com.example.newsapi.Article

data class NewsApiResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)