package com.matej.orientednews.ui.news.favourites

import com.matej.orientednews.model.favourites.FavouriteNews

interface FavouritesContract {

    interface View{
        fun onGetFavouritesSuccessful(favoriteNews: List<FavouriteNews>)
        fun onGetFavouritesFailed()
        fun onGetCurrentUserSuccessful(currentUser: String)
        fun onGetCurrentUserFailed()
    }

    interface Presenter{
        fun setView(view: View)
        fun getFavouriteNews() : List<FavouriteNews>
        fun getCurrentUser(): String
    }
}