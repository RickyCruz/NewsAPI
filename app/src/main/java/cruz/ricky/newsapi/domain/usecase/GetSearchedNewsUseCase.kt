package cruz.ricky.newsapi.domain.usecase

import cruz.ricky.newsapi.domain.repository.NewsRepository

class GetSearchedNewsUseCase(private val newsRepository: NewsRepository) {
}