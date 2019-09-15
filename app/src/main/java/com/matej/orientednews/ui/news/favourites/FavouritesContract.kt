package com.matej.orientednews.ui.news.favourites

import com.matej.orientednews.model.favourites.FavouriteNews

interface FavouritesContract {

    interface View{
        fun onGetFavouritesSuccessful(favoriteNews: List<FavouriteNews>)
    }

    interface Presenter{
        fun setView(view: View)
        fun getFavouriteNews(user: String)
        fun getCurrentUser(): String
        fun removeFavourite(link: String)
    }
}