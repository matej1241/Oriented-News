package com.matej.orientednews.ui.news.newsList.rightNews

import com.matej.orientednews.model.favourites.FavouriteNews
import com.matej.orientednews.model.rss.RssFeed

interface NewsRightContract {

    interface View{
        fun onGetNewsSuccessful(news: RssFeed?)
        fun onGetNewsFailed()
    }

    interface Presenter{
        fun setView(view: View)
        fun getNews()
        fun insertNews(favouriteNews: FavouriteNews)
        fun removeFavourite(link: String)
        fun getCurrentUser(): String
    }
}