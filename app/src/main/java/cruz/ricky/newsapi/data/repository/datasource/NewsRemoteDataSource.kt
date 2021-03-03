package cruz.ricky.newsapi.data.repository.datasource

import cruz.ricky.newsapi.data.model.APIResponse
import retrofit2.Response

interface NewsRemoteDataSource {

    suspend fun getTopHeadlines(): Response<APIResponse>

}