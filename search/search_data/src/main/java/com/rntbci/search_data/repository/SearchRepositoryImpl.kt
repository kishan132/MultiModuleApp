package com.rntbci.search_data.repository

import com.rntbci.search_data.mapper.toDomainArticle
import com.rntbci.search_data.network.SearchApi
import com.rntbci.search_domain.model.Article
import com.rntbci.search_domain.repository.SearchRepository

class SearchRepositoryImpl(private val searchApi: SearchApi):SearchRepository {
    override suspend fun getSearchArticle(map: MutableMap<String, String>): List<Article> {
        return searchApi.getSearchArticles(map).articles.map { it.toDomainArticle() }
    }
}