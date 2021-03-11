package cz.vondr.pact.consumer.dao

import com.fasterxml.jackson.databind.ObjectMapper

fun main() {
    val resp = ListArticlesResponse(
            listOf(
                    Article("Zásadní zprávy", 104),
                    Article("O koťátkách", 5684),
                    Article("Drby", 4512384)
            )
    )

    val json = ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(resp)

    println(json)

}