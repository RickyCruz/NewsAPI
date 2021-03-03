package cruz.ricky.newsapi.domain.usecase

import cruz.ricky.newsapi.data.model.Article
import cruz.ricky.newsapi.domain.repository.NewsRepository

class SaveNewsUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(article: Article) = newsRepository.saveNews(article)

}