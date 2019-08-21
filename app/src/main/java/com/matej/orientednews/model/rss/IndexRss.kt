package com.matej.orientednews.model.rss

data class IndexRSS(
    val status: String,
    val feed: Feed,
    val items: List<Items>
)