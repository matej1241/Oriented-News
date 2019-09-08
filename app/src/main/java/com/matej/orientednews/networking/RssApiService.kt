package com.matej.orientednews.networking

import com.matej.orientednews.model.rss.RssFeed
import retrofit2.Call
import retrofit2.http.GET

interface RssApiService {

    @GET("api.json?rss_url=https://www.index.hr/rss")
    fun getIndexRss(): Call<RssFeed>

    @GET("api.json?rss_url=https://www.kamenjar.com/rss")
    fun getKamenjarRss(): Call<RssFeed>
}