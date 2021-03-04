package cruz.ricky.newsapi.presentation.di

import cruz.ricky.newsapi.data.repository.NewsRepositoryImpl
import cruz.ricky.newsapi.data.repository.datasource.NewsRemoteDataSource
import cruz.ricky.newsapi.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideNewsRepository(newsRemoteDataSource: NewsRemoteDataSource): NewsRepository {
        return NewsRepositoryImpl(newsRemoteDataSource)
    }

}