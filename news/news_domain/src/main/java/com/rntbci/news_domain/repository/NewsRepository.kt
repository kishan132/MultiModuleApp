package com.rntbci.news_domain.repository

import com.rntbci.news_domain.model.Article

interface NewsRepository {

    suspend fun getNewsArticle() : List<Article>

}