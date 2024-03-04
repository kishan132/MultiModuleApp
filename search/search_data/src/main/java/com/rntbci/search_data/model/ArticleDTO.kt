package com.rntbci.search_data.model

// DTO - Data Transfer Object (actual data)

data class ArticleDTO(
    val author: String?,
    val content: String?,
    val description: String?,
    val publishedAt: String?,
    val source: SourceDTO?,
    val title: String?,
    val url: String?,
    val urlToImage: String?
)