package cruz.ricky.newsapi.domain.repository

import cruz.ricky.newsapi.data.model.APIResponse
import cruz.ricky.newsapi.data.model.Article
import cruz.ricky.newsapi.data.util.Resource
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    suspend fun getNewsHeadlines(): Resource<APIResponse>

    suspend fun getSearchedNews(searchQuery: String): Resource<APIResponse>

    suspend fun saveNews(article: Article)

    suspend fun deleteNews(article: Article)

    fun getSavedNews(): Flow<List<Article>>

}