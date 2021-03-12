package cruz.ricky.newsapi.data.repository.datasourceImpl

import cruz.ricky.newsapi.data.api.NewsAPIService
import cruz.ricky.newsapi.data.model.APIResponse
import cruz.ricky.newsapi.data.repository.datasource.NewsRemoteDataSource
import retrofit2.Response

class NewsRemoteDataSourceImpl(private val newsAPIService: NewsAPIService): NewsRemoteDataSource {

    override suspend fun getTopHeadlines(country: String, page: Int): Response<APIResponse> {
        return newsAPIService.getTopHeadLines(country, page)
    }

    override suspend fun getSearchedNews(
        country: String,
        searchQuery: String,
        page: Int
    ): Response<APIResponse> {
        return  newsAPIService.getSearchTopHeadLines(country, searchQuery, page)
    }

}