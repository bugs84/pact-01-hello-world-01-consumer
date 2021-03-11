package cz.vondr.pact.consumer

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.jcabi.http.request.JdkRequest
import com.jcabi.http.response.JsonResponse
import cz.vondr.pact.consumer.dao.ListArticlesResponse

class ArticlesConsumer(val articlesProducerUrl: String) {

    fun listAllArticles(): ListArticlesResponse {
        val response = JdkRequest("$articlesProducerUrl/articles.json").fetch()
        val json = response.`as`(JsonResponse::class.java).body()

        val mapper = jacksonObjectMapper()
        val listArticlesResponse = mapper.readValue(json, ListArticlesResponse::class.java)

        return listArticlesResponse
    }

    fun lengthOfAllArticles(): Int {
        return listAllArticles().articles.sumBy { it.length }
    }

}