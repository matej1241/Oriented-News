package com.matej.orientednews.persistance.dbRepository

import com.matej.orientednews.model.favourites.FavouriteNews

interface FavouritesRepository {

    fun insert(favouriteNews: FavouriteNews)

    fun getAllNews(): List<FavouriteNews>
}