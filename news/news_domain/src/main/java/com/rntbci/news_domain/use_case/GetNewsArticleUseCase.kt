package com.rntbci.news_domain.use_case

import com.rntbci.common_utils.Resource
import com.rntbci.news_domain.model.Article
import com.rntbci.news_domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception

class GetNewsArticleUseCase(private val newsRepository: NewsRepository) {

    //The invoke function is invoked when you use the parentheses () syntax on an object of the class.
    //val a = ClassName() // Calls the 'invoke' operator function

    operator fun invoke(): Flow<Resource<List<Article>>> = flow {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(data = newsRepository.getNewsArticle()))
        } catch (e: Exception) {
            emit(Resource.Error(message = e.message.toString()))
        }
    }

}