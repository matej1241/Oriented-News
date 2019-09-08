package com.matej.orientednews.persistance.dbRepository

import com.matej.orientednews.db.FavouritesDao
import com.matej.orientednews.model.favourites.FavouriteNews

class FavouritesRepositoryImpl(private val favouritesDao: FavouritesDao): FavouritesRepository {

    override fun insert(favouriteNews: FavouriteNews) {
        favouritesDao.insertNews(favouriteNews)
    }

    override fun getAllNews(): List<FavouriteNews> = favouritesDao.getAllNews()

}