package com.rntbci.news_data.mapper

import com.rntbci.news_data.model.ArticleDTO
import com.rntbci.news_domain.model.Article

fun ArticleDTO.toDomainArticle(): Article {
    return Article(
        author = this.author ?: "",
        content = this.content?: "",
        description = this.description?: "",
        title = this.title?: "",
        urlToImage = this.urlToImage?: ""
    )
}