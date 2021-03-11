package cz.vondr.pact.consumer.dao

data class ListArticlesResponse(
        val articles: List<Article>
)

data class Article(
        val name: String,
        val length: Int
)



