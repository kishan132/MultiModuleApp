package com.rntbci.search_domain.repository

import com.rntbci.search_domain.model.Article

interface SearchRepository {

    suspend fun getSearchArticle(map: MutableMap<String,String>):List<Article>
}