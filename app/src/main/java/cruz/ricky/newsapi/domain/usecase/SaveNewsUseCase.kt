package cruz.ricky.newsapi.domain.usecase

import cruz.ricky.newsapi.domain.repository.NewsRepository

class SaveNewsUseCase(private val newsRepository: NewsRepository) {
}