package cruz.ricky.newsapi.domain.usecase

import cruz.ricky.newsapi.domain.repository.NewsRepository

class GetSavedNewsUseCase(private val newsRepository: NewsRepository) {
}