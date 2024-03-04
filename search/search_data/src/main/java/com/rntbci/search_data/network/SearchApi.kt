package com.rntbci.search_data.network

import com.rntbci.search_data.model.NewsResponse
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface SearchApi {

    //https://newsapi.org/v2/everything?q=apple&from=2024-03-10&to=2024-03-10&sortBy=popularity&apiKey=API_KEY

    @GET("everything")
    suspend fun getSearchArticles(
        @QueryMap map: MutableMap<String,String>
    ) : NewsResponse
}