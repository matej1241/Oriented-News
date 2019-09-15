package com.matej.orientednews.ui.news.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.koushikdutta.ion.Ion
import com.matej.orientednews.R
import com.matej.orientednews.common.FavouriteClickListener
import com.matej.orientednews.common.INDEX
import com.matej.orientednews.common.KAMENJAR
import com.matej.orientednews.common.NewsClickListener
import com.matej.orientednews.model.rss.Feed
import com.matej.orientednews.model.rss.Items
import kotlinx.android.synthetic.main.item_news.view.*

class NewsAdapter(
    private val favouriteClickListener: FavouriteClickListener,
    private val newsClickListener: NewsClickListener): RecyclerView.Adapter<NewsHolder>() {

    private val news: MutableList<Items> = mutableListOf()
    private lateinit var feed: Feed

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return NewsHolder(view)
    }

    override fun getItemCount(): Int = news.size

    override fun onBindViewHolder(holder: NewsHolder, position: Int) {
        holder.bindData(news[position], feed, this.favouriteClickListener, this.newsClickListener)
    }

    fun setData(news: List<Items>) {
        this.news.clear()
        this.news.addAll(news)
        notifyDataSetChanged()
    }

    fun setFeedData(feed: Feed){
        this.feed = feed
        notifyDataSetChanged()
    }

    fun refreshData(){
        notifyDataSetChanged()
    }

}

class NewsHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    fun bindData(item: Items, feed: Feed, favouriteClickListener: FavouriteClickListener, newsClickListener: NewsClickListener){
        itemView.feedImage.setOnClickListener { newsClickListener(item.link) }
        itemView.titleText.setOnClickListener { newsClickListener(item.link) }
        itemView.setFavouriteImg.setOnClickListener { favouriteClickListener(item, feed) }

        if (item.isFavourite) itemView.setFavouriteImg.setImageResource(R.drawable.ic_favorite_orange_24dp)
        else itemView.setFavouriteImg.setImageResource(R.drawable.ic_favorite_border_orange)

        when(feed.title){
            INDEX -> itemView.sourceText.text = "Index.hr"
            KAMENJAR -> itemView.sourceText.text = "Kamenjar.com"
        }

        itemView.titleText.text = item.title
        Ion.with(itemView.feedImage)
            .placeholder(R.drawable.news_placeholder)
            .load(item.thumbnail)
    }
}