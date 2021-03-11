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
@PactTestFor(providerName = "MultipleMethods")
class MultipleRestCallsPactTest {


    @Pact(provider = "MultipleMethods", consumer = "test_consumer")
    fun createPact(builder: PactDslWithProvider): RequestResponsePact {
        return builder
                .given("test state")

                .uponReceiving("ExampleJavaConsumerPactTest test interaction")
                .path("/articles.json")
                .method("GET")
                .willRespondWith()
                .status(200)
                .body("""{"responsetest": true}""")

                .uponReceiving("ping")
                .path("/ping")
                .method("GET")
                .willRespondWith()
                .status(204)

                .uponReceiving("some post method")
                .path("/somePost")
                .method("POST")
                .willRespondWith()
                .status(204)

                .toPact()
    }

    @Test
    fun `get article json return expected response`(mockServer: MockServer) {
        //TODO context for my kt tests and we are have  given when then tlala testy a muzu to ivalidovat na thread localu

        val url = mockServer.getUrl()

        "ping".run {
            val response = JdkRequest("$url/ping").fetch()
            println(response)
            assertThat(response.status()).isEqualTo(204)
        }

        "articles".run {
            // Example, that mock works:
            val response = JdkRequest("$url/articles.json").fetch()
            println(response)
            val json = response.`as`(JsonResponse::class.java)
                    .json()
            val responseTest = json.readObject().getBoolean("responsetest")
            assertThat(responseTest).isEqualTo(true)
        }

        "somePost".run {
            val response = JdkRequest("$url/somePost").method("POST").fetch()
            println(response)
            assertThat(response.status()).isEqualTo(204)
        }
    }
}