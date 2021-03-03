package cruz.ricky.newsapi.domain.usecase

import cruz.ricky.newsapi.data.model.APIResponse
import cruz.ricky.newsapi.data.util.Resource
import cruz.ricky.newsapi.domain.repository.NewsRepository

class GetSearchedNewsUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(searchQuery: String): Resource<APIResponse> {
        return newsRepository.getSearchedNews(searchQuery)
    }

}