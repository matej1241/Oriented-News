package com.matej.orientednews.networking

import com.matej.orientednews.model.rss.RssFeed
import retrofit2.Call
import retrofit2.http.GET

interface RssApiService {

    @GET("api.json?rss_url=https://www.index.hr/rss&api_key=2pcnzs5qu0yu9drmn6eghsb7abhwzg3bulbxk0yn&count=50")
    fun getIndexRss(): Call<RssFeed>

    @GET("api.json?rss_url=https://www.kamenjar.com/rss&api_key=2pcnzs5qu0yu9drmn6eghsb7abhwzg3bulbxk0yn&count=50")
    fun getKamenjarRss(): Call<RssFeed>
}