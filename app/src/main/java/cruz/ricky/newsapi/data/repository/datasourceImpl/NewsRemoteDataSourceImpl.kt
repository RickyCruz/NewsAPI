package cruz.ricky.newsapi.data.repository.datasourceImpl

import cruz.ricky.newsapi.data.api.NewsAPIService
import cruz.ricky.newsapi.data.model.APIResponse
import cruz.ricky.newsapi.data.repository.datasource.NewsRemoteDataSource
import retrofit2.Response

class NewsRemoteDataSourceImpl(
    private val newsAPIService: NewsAPIService,
    private val country: String,
    private val page: Int
): NewsRemoteDataSource {

    override suspend fun getTopHeadlines(): Response<APIResponse> {
        return newsAPIService.getTopHeadLines(country, page)
    }

}