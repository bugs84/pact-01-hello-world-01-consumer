package cz.vondr.pact.consumer

import au.com.dius.pact.consumer.MockServer
import au.com.dius.pact.consumer.dsl.PactDslWithProvider
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt
import au.com.dius.pact.consumer.junit5.PactTestFor
import au.com.dius.pact.core.model.RequestResponsePact
import au.com.dius.pact.core.model.annotations.Pact
import com.jcabi.http.request.JdkRequest
import com.jcabi.http.response.JsonResponse
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith


@ExtendWith(PactConsumerTestExt::class)
@PactTestFor(providerName = "ArticlesProvider")
class FirstPactTest {


    @Pact(provider = "ArticlesProvider", consumer = "test_consumer")
    fun createPact(builder: PactDslWithProvider): RequestResponsePact {
        return builder
                .given("test state")
                .uponReceiving("ExampleJavaConsumerPactTest test interaction")
                .path("/articles.json")
                .method("GET")
                .willRespondWith()
                .status(200)
                .body("""{"articles": [
                    
                   ]
                 }""".trimIndent())
                .toPact()
    }

    @Test
    fun `get article json return expected response`(mockServer: MockServer) {
        // Note test with more realistic consumer application is in file "ArticlesConsumerTest"

        // Example, that mock works:
        val response = JdkRequest("${mockServer.getUrl()}/articles.json").fetch()
        println(response)
        val json = response.`as`(JsonResponse::class.java)
                .json()
        val articlesArray = json.readObject().getJsonArray("articles")
        assertThat(articlesArray).hasSize(0)
    }



}