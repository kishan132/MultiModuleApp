package com.rntbci.news_data.di

import com.rntbci.news_data.network.NewsApiService
import com.rntbci.news_data.repository.NewsRepoImpl
import com.rntbci.news_data.room.NewsDAO
import com.rntbci.news_domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit


@InstallIn(SingletonComponent::class)
@Module
object NewsDataModule {

    @Provides
    fun provideNewsApiService(retrofit: Retrofit) : NewsApiService {
        return retrofit.create(NewsApiService::class.java)
    }

    @Provides
    fun provideNewsRepository(newsApiService: NewsApiService, newsDAO: NewsDAO) : NewsRepository {
        return NewsRepoImpl(newsApiService, newsDAO)
    }

}