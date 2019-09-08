package com.matej.orientednews.ui.news.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.koushikdutta.ion.Ion
import com.matej.orientednews.R
import com.matej.orientednews.common.INDEX
import com.matej.orientednews.common.KAMENJAR
import com.matej.orientednews.model.favourites.FavouriteNews
import com.matej.orientednews.model.rss.Items
import kotlinx.android.synthetic.main.item_news.view.*

class FavouriteNewsAdapter: RecyclerView.Adapter<FavouriteNewsHolder>() {

    private val favouriteNews: MutableList<FavouriteNews> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavouriteNewsHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return FavouriteNewsHolder(view)
    }

    override fun getItemCount(): Int = favouriteNews.size

    override fun onBindViewHolder(holder: FavouriteNewsHolder, position: Int) {
        holder.bindData(favouriteNews[position])
    }

    fun setData(news: List<FavouriteNews>) {
        this.favouriteNews.clear()
        this.favouriteNews.addAll(news)
        notifyDataSetChanged()
    }

    fun refreshData(){
        notifyDataSetChanged()
    }
}

class FavouriteNewsHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    fun bindData(news: FavouriteNews){
        when(news.feed){
            INDEX -> itemView.sourceText.text = "Index.hr"
            KAMENJAR -> itemView.sourceText.text = "Kamenjar.com"
        }
        itemView.setFavouriteImg.setImageResource(0)
        itemView.titleText.text = news.title
        Ion.with(itemView.feedImage)
            .placeholder(R.drawable.ic_launcher_foreground)
            .load(news.thumbnail)
    }
}