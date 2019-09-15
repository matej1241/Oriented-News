package com.matej.orientednews.ui.news.newsList.leftNews

import android.content.Intent
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.matej.orientednews.OrientedNews
import com.matej.orientednews.R
import com.matej.orientednews.common.INDEX
import com.matej.orientednews.model.favourites.FavouriteNews
import com.matej.orientednews.model.rss.Feed
import com.matej.orientednews.model.rss.Items
import com.matej.orientednews.model.rss.RssFeed
import com.matej.orientednews.ui.base.BaseFragment
import com.matej.orientednews.ui.news.adapter.NewsAdapter
import com.matej.orientednews.ui.webView.NewsWebView
import com.matej.orientednews.ui.webView.NewsWebView.Companion.WEB_URL
import kotlinx.android.synthetic.main.fragment_news_left.*
import org.koin.android.ext.android.inject

class NewsLeftFragment : BaseFragment(), NewsLeftContract.View {

    private val presenter: NewsLeftContract.Presenter by inject()
    private val adapter by lazy { NewsAdapter(::onFavouriteClicked, ::onNewsClicked) }

    override fun getLayoutResourceId(): Int = R.layout.fragment_news_left

    override fun setupUi() {
        presenter.setView(this)
        newsLeftRecyclerView.layoutManager = LinearLayoutManager(context)
        newsLeftRecyclerView.adapter = adapter
        getNews()
    }

    override fun setOnClickListeners() {
    }

    private fun getNews() {
        progressBar.visibility = View.VISIBLE
        presenter.getNews()
    }

    override fun onGetNewsSuccessful(news: RssFeed?) {
        val data = news!!.items
        val feed = news.feed
        adapter.setData(data)
        adapter.setFeedData(feed)
        progressBar.visibility = View.GONE
    }

    override fun onGetNewsFailed() {
        Log.d("Tag", "Greska")
    }

    private fun onFavouriteClicked(items: Items, feed: Feed) {
        if(items.isFavourite){
            presenter.removeFavourite(items.link)
            items.isFavourite = false
            adapter.refreshData()
        }
        else{
            val news = FavouriteNews(
                user = presenter.getCurrentUser(),
                source = INDEX,
                title = items.title,
                link = items.link,
                thumbnail = items.thumbnail,
                feed = feed.title
            )
            presenter.insertNews(news)
            items.isFavourite = true
            adapter.refreshData()
        }
    }

    private fun onNewsClicked(url: String){
        val intent = Intent(OrientedNews.instance, NewsWebView::class.java)
        intent.putExtra(WEB_URL, url)
        startActivity(intent)
    }

    companion object {
        fun newInstance(): Fragment {
            return NewsLeftFragment()
        }
    }
}
