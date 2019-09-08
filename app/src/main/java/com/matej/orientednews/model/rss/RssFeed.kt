package com.matej.orientednews.model.rss

data class RssFeed(
    val status: String,
    val feed: Feed,
    val items: List<Items>
)