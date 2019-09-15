package com.matej.orientednews.domain.favourites

import com.matej.orientednews.model.favourites.FavouriteNews

interface FavouritesDbInteractor {

    fun insert(favouriteNews: FavouriteNews)

    fun delete(link: String)

    fun getAllNews(user: String): List<FavouriteNews>
}