package com.matej.orientednews.persistance

import com.matej.orientednews.model.rss.RssFeed
import com.matej.orientednews.networking.RssApiService
import retrofit2.Call

class IndexRssRepositoryImpl(private val rssApiService: RssApiService): IndexRssRepository {
    override fun getIndexRss(): Call<RssFeed> = rssApiService.getIndexRss()
}