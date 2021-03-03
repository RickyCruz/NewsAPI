package cruz.ricky.newsapi.domain.usecase

import cruz.ricky.newsapi.data.model.Article
import cruz.ricky.newsapi.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetSavedNewsUseCase(private val newsRepository: NewsRepository) {

    fun execute(): Flow<List<Article>> {
        return newsRepository.getSavedNews()
    }

}