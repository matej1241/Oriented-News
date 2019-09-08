package com.matej.orientednews.persistance

import com.matej.orientednews.model.rss.RssFeed
import retrofit2.Call

interface IndexRssRepository {
    fun getIndexRss(): Call<RssFeed>
}