package com.matej.orientednews.domain.favourites

import com.matej.orientednews.model.favourites.FavouriteNews

interface FavouritesDbInteractor {

    fun insert(favouriteNews: FavouriteNews)

    fun getAllNews(): List<FavouriteNews>
}