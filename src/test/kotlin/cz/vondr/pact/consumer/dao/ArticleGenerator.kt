package cz.vondr.pact.consumer.dao

import com.fasterxml.jackson.databind.ObjectMapper

fun main() {
    val resp = ListArticlesResponse(
            listOf(
                Article("Basic news", 104),
                Article("About dogs", 5684),
                Article("Gossip", 4512384),
            )
    )

    val json = ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(resp)

    println(json)

}