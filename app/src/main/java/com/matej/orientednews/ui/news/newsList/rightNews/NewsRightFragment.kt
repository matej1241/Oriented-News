package com.matej.orientednews.ui.news.newsList.rightNews


import android.util.Log
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager

import com.matej.orientednews.R
import com.matej.orientednews.model.favourites.FavouriteNews
import com.matej.orientednews.model.rss.Feed
import com.matej.orientednews.model.rss.Items
import com.matej.orientednews.model.rss.RssFeed
import com.matej.orientednews.ui.base.BaseFragment
import com.matej.orientednews.ui.news.adapter.NewsAdapter
import kotlinx.android.synthetic.main.fragment_news_right.*
import org.koin.android.ext.android.inject

class NewsRightFragment : BaseFragment(), NewsRightContract.View {

    private val presenter: NewsRightContract.Presenter by inject()
    private val adapter by lazy { NewsAdapter(::onFavouriteClicked) }

    override fun getLayoutResourceId(): Int = R.layout.fragment_news_right

    override fun setupUi() {
        presenter.setView(this)
        newsRightRecyclerView.layoutManager = LinearLayoutManager(context)
        newsRightRecyclerView.adapter = adapter
        getNews()
    }

    private fun getNews() {
        presenter.getNews()
    }

    override fun setOnClickListeners() {
    }

    override fun onGetNewsSuccessful(news: RssFeed?) {
        val data = news!!.items
        val feed = news!!.feed
        adapter.setData(data)
        adapter.setFeedData(feed)
    }

    override fun onGetNewsFailed() {
        Log.d("Tag", "Greska")
    }

    private fun onFavouriteClicked(items: Items, feed: Feed) {
        if (!items.isFavourite) items.isFavourite = true
        else items.isFavourite = false
        adapter.refreshData()
        val news = FavouriteNews(
            user = presenter.getCurrentUser(),
            source = "Index",
            title = items.title,
            link = items.link,
            thumbnail = items.thumbnail,
            feed = feed.title
        )
        presenter.insertNews(news)
    }

    companion object {
        fun newInstance(): Fragment {
            return NewsRightFragment()
        }
    }
}
