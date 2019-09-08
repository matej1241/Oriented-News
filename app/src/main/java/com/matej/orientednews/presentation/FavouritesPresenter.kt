package com.matej.orientednews.presentation

import com.matej.orientednews.domain.favourites.FavouritesDbInteractor
import com.matej.orientednews.domain.login.CurrentUserUseCase
import com.matej.orientednews.model.favourites.FavouriteNews
import com.matej.orientednews.ui.news.favourites.FavouritesContract

class FavouritesPresenter(
    private val currentUserUseCase: CurrentUserUseCase,
    private val favouritesDbInteractor: FavouritesDbInteractor): FavouritesContract.Presenter {

    private lateinit var view: FavouritesContract.View

    override fun setView(view: FavouritesContract.View) {
        this.view = view
    }

    override fun getFavouriteNews() : List<FavouriteNews> = favouritesDbInteractor.getAllNews()


    override fun getCurrentUser(): String {
        return currentUserUseCase.execute()
    }
}