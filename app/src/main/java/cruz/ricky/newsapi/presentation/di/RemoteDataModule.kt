package cruz.ricky.newsapi.presentation.di

import cruz.ricky.newsapi.data.api.NewsAPIService
import cruz.ricky.newsapi.data.repository.datasource.NewsRemoteDataSource
import cruz.ricky.newsapi.data.repository.datasourceImpl.NewsRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class RemoteDataModule {

    @Provides
    @Singleton
    fun provideNewsRemoteDataSource(newsAPIService: NewsAPIService): NewsRemoteDataSource {
        return NewsRemoteDataSourceImpl(newsAPIService)
    }

}