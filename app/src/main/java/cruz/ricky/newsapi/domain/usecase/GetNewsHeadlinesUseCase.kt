package cruz.ricky.newsapi.domain.usecase

import cruz.ricky.newsapi.domain.repository.NewsRepository

class GetNewsHeadlinesUseCase(private val newsRepository: NewsRepository) {
}