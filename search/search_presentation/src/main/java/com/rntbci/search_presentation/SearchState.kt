package com.rntbci.search_presentation

import com.rntbci.search_domain.model.Article

data class SearchState(
    val isLoading: Boolean = false,
    val isError: String = "",
    val data: List<Article>?= null
)
