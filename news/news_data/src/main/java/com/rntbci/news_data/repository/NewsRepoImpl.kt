package com.rntbci.news_data.repository

import com.rntbci.news_data.mapper.toDomainArticle
import com.rntbci.news_data.network.NewsApiService
import com.rntbci.news_data.room.NewsDAO
import com.rntbci.news_domain.model.Article
import com.rntbci.news_domain.repository.NewsRepository

class NewsRepoImpl(private val newsApiService: NewsApiService, private val newsDAO: NewsDAO) :
    NewsRepository {
    override suspend fun getNewsArticle(): List<Article> {

        return try {
            val temp =
                newsApiService.getNewsArticles(country = "us").articles.map { it.toDomainArticle() }
            newsDAO.insertList(temp)
            newsDAO.getNewsArticle()
        } catch (e: Exception) {
            newsDAO.getNewsArticle()
        }


    }
}