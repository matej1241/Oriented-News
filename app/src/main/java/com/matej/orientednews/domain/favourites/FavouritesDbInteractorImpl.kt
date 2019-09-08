package com.matej.orientednews.domain.favourites

import com.matej.orientednews.model.favourites.FavouriteNews
import com.matej.orientednews.persistance.dbRepository.FavouritesRepository

class FavouritesDbInteractorImpl(private val favouritesRepository: FavouritesRepository): FavouritesDbInteractor {

    override fun insert(favouriteNews: FavouriteNews) {
        favouritesRepository.insert(favouriteNews)
    }

    override fun getAllNews(): List<FavouriteNews> = favouritesRepository.getAllNews()
}