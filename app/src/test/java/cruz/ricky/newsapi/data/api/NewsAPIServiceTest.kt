package cruz.ricky.newsapi.data.api

import com.google.common.truth.Truth.assertThat
import cruz.ricky.newsapi.BuildConfig
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsAPIServiceTest {

    private lateinit var service: NewsAPIService
    private lateinit var server: MockWebServer

    @Before
    fun setUp() {
        server = MockWebServer()
        service = Retrofit.Builder()
            .baseUrl(server.url(""))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsAPIService::class.java)
    }

    private fun enqueueMockResponse(fileName: String) {
        val inputStream = javaClass.classLoader!!.getResourceAsStream(fileName)
        val source = inputStream.source().buffer()
        val mockResponse = MockResponse()
        mockResponse.setBody(source.readString(Charsets.UTF_8))
        server.enqueue(mockResponse)
    }

    @Test
    fun getTopHeadlines_sentRequest_receivedExpected() {
        runBlocking {
            enqueueMockResponse("news_response.json")
            val responseBody = service.getTopHeadLines("us", 1).body()
            val request = server.takeRequest()

            assertThat(responseBody).isNotNull()
            assertThat(request.path).isEqualTo("/v2/top-headlines?country=us&page=1&apiKey=${ BuildConfig.API_KEY }")
        }
    }

    @Test
    fun getTopHeadlines_receivedResponse_correctPagesSize() {
        runBlocking {
            enqueueMockResponse("news_response.json")
            val responseBody = service.getTopHeadLines("us", 1).body()
            val articles = responseBody!!.articles

            assertThat(articles.size).isEqualTo(20)
        }
    }

    @Test
    fun getTopHeadlines_receivedResponse_correctContent() {
        runBlocking {
            enqueueMockResponse("news_response.json")
            val responseBody = service.getTopHeadLines("us", 1).body()
            val articles = responseBody!!.articles
            val article = articles[1]

            assertThat(article.author).isEqualTo("Investor's Business Daily")
            assertThat(article.url).isEqualTo("https://www.investors.com/market-trend/stock-market-today/dow-jones-reverses-lower-nasdaq-leads-sell-off-stocks-fall-on-earnings/")
            assertThat(article.title).isEqualTo("Dow Jones Reverses Lower As Nasdaq Leads Sell-Off; These Stocks Fall On Earnings - Investor's Business Daily")
            assertThat(article.publishedAt).isEqualTo("2021-03-03T21:28:00Z")
        }
    }

    @After
    fun tearDown() {
        server.shutdown()
    }

}
