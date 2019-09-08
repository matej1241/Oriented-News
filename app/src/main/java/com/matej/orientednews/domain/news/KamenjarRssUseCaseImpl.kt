package com.matej.orientednews.domain.news

import com.matej.orientednews.common.IndexErrorLambda
import com.matej.orientednews.common.SuccessLambda
import com.matej.orientednews.model.rss.RssFeed
import com.matej.orientednews.networking.RssApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class KamenjarRssUseCaseImpl(private val rssApiService: RssApiService): KamenjarRssUseCase {
    override fun execute(successLambda: SuccessLambda<RssFeed>, onFailure: IndexErrorLambda) {
        rssApiService.getKamenjarRss().enqueue(object : Callback<RssFeed> {
            override fun onFailure(call: Call<RssFeed>, t: Throwable) {
                run{onFailure}
            }

            override fun onResponse(call: Call<RssFeed>?, response: Response<RssFeed>) {
                if (response.isSuccessful) {
                    response.body()?.run(successLambda)
                }
            }
        })
    }
}