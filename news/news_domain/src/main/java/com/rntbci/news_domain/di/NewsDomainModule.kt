package com.rntbci.news_domain.di

import com.rntbci.news_domain.repository.NewsRepository
import com.rntbci.news_domain.use_case.GetNewsArticleUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class NewsDomainModule {

    @Provides
    fun provideGetNewsUseCase(newsRepository: NewsRepository) : GetNewsArticleUseCase {
        return GetNewsArticleUseCase(newsRepository)
    }

}