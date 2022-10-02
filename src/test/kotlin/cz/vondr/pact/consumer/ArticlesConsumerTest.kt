package cz.vondr.pact.consumer

import au.com.dius.pact.consumer.MockServer
import au.com.dius.pact.consumer.dsl.PactDslWithProvider
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt
import au.com.dius.pact.consumer.junit5.PactTestFor
import au.com.dius.pact.core.model.RequestResponsePact
import au.com.dius.pact.core.model.annotations.Pact
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith


@ExtendWith(PactConsumerTestExt::class)
@PactTestFor(providerName = "ArticlesProvider")
class ArticlesConsumerTest {

    @Pact(provider = "ArticlesProvider", consumer = "ArticlesConsumer")
    fun createPact(builder: PactDslWithProvider): RequestResponsePact {
        return builder
                .given("Provider with three articles")
                .uponReceiving("ListAllArticles")
                .path("/articles.json")
                .method("GET")
                .willRespondWith()
                .status(200)
                .body(
                    """
                    {
                      "articles" : [ {
                        "name" : "Basic news",
                        "length" : 104
                      }, {
                        "name" : "About dogs",
                        "length" : 5684
                      }, {
                        "name" : "Gossip",
                        "length" : 4512384
                      } ]
                    }
                """.trimIndent())
                .toPact()
    }

    @Test
    fun `getArticlesCount return expected number of articles`(articlesProvider: MockServer) {
        // given
        val articlesConsumer = ArticlesConsumer(articlesProvider.getUrl())

        // when
        val articlesCount = articlesConsumer.getArticlesCount()

        // then
        assertThat(articlesCount).isEqualTo(3)
    }

    @Test
    fun `lengthOfAllArticles return is big enough`(articlesProvider: MockServer) {
        // given
        val articlesConsumer = ArticlesConsumer(articlesProvider.getUrl())

        // when
        val totalLength = articlesConsumer.lengthOfAllArticles()

        // then
        assertThat(totalLength).isGreaterThan(4_000_000)
    }


}