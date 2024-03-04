package com.rntbci.search_presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rntbci.common_utils.Resource
import com.rntbci.search_domain.use_case.GetSearchArticleUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.forEach
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(private val getNewsArticleUseCase : GetSearchArticleUseCase): ViewModel() {

    private val _searchArticle = MutableStateFlow(SearchState())
    val searchArticle: StateFlow<SearchState> = _searchArticle

    fun getSearchArticles(map : MutableMap<String,String>){

        // for every emission "onEach" will call
        getNewsArticleUseCase(map).onEach{

            when(it){
                is Resource.Loading -> {
                    _searchArticle.value = SearchState(isLoading = true)
                }
                is Resource.Success -> {
                    _searchArticle.value = SearchState(data = it.data)
                }
                is Resource.Error -> {
                    _searchArticle.value = SearchState(isError = it.message)
                }
            }

        }.launchIn(viewModelScope)
    }

}