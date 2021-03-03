package cruz.ricky.newsapi.domain.usecase

import cruz.ricky.newsapi.domain.repository.NewsRepository

class DeleteSavedNewsUseCase(private val newsRepository: NewsRepository) {
}