package com.example.newsapi.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapi.data.NewsApiResponse
import com.example.newsapi.data.NewsApiService
import kotlinx.coroutines.launch

class NewsViewModel: ViewModel() {
    var newsApiResponse: NewsApiResponse by mutableStateOf(NewsApiResponse(
        listOf(),
        "",
        0
    ))
    private var errorMessage: String by mutableStateOf("")
    fun getNews() {
        viewModelScope.launch {
            val newsApiService = NewsApiService.getInstance()
            try {
                newsApiResponse = newsApiService.getTopHeadlines(
                    "67613f43c2fa49aeb98568270d568d36",
                    "us"
                )
            }
            catch(e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }
}