package cruz.ricky.newsapi.presentation.di

import cruz.ricky.newsapi.domain.repository.NewsRepository
import cruz.ricky.newsapi.domain.usecase.GetNewsHeadlinesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class UseCaseModule {

    @Provides
    @Singleton
    fun provideGetNewsHeadLinesUseCase(newsRepository: NewsRepository): GetNewsHeadlinesUseCase {
        return GetNewsHeadlinesUseCase(newsRepository)
    }

}