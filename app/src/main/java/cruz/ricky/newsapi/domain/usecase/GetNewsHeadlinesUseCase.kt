package cruz.ricky.newsapi.domain.usecase

import cruz.ricky.newsapi.data.model.APIResponse
import cruz.ricky.newsapi.data.util.Resource
import cruz.ricky.newsapi.domain.repository.NewsRepository

class GetNewsHeadlinesUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(): Resource<APIResponse> {
        return newsRepository.getNewsHeadlines()
    }

}