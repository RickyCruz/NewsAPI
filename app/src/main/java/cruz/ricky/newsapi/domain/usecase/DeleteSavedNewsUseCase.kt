package cruz.ricky.newsapi.domain.usecase

import cruz.ricky.newsapi.data.model.Article
import cruz.ricky.newsapi.domain.repository.NewsRepository

class DeleteSavedNewsUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(article: Article) = newsRepository.deleteNews(article)

}