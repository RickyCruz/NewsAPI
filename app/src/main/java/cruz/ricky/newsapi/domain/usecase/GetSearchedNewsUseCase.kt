package cruz.ricky.newsapi.domain.usecase

import cruz.ricky.newsapi.data.model.APIResponse
import cruz.ricky.newsapi.data.util.Resource
import cruz.ricky.newsapi.domain.repository.NewsRepository

class GetSearchedNewsUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(country: String, searchQuery: String, page: Int): Resource<APIResponse> {
        return newsRepository.getSearchedNews(country, searchQuery, page)
    }

}