package com.rntbci.newsApp

import android.content.Context
import com.rntbci.common_utils.Navigator
import com.rntbci.newsApp.navigation.DefaultNavigator
import com.rntbci.newsApp.room.AppDatabase
import com.rntbci.news_data.room.NewsDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    @Singleton
    fun provideProvider() : Navigator.Provider {
        return DefaultNavigator()
    }

    @Provides
    @Singleton
    fun provideNewsDatabase(@ApplicationContext context: Context) : AppDatabase {
        return AppDatabase.getInstance(context)
    }

    @Provides
    fun provideNewsDao(appDatabase: AppDatabase) : NewsDAO {
        return appDatabase.getNewsDao()
    }

}