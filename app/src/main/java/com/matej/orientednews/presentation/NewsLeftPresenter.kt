package com.matej.orientednews.presentation

import com.matej.orientednews.domain.favourites.FavouritesDbInteractor
import com.matej.orientednews.domain.login.CurrentUserUseCase
import com.matej.orientednews.domain.news.IndexRssUseCase
import com.matej.orientednews.model.favourites.FavouriteNews
import com.matej.orientednews.model.rss.RssFeed
import com.matej.orientednews.ui.news.newsList.leftNews.NewsLeftContract

class NewsLeftPresenter(
    private val indexRssUseCase: IndexRssUseCase,
    private val favouritesDbInteractor: FavouritesDbInteractor,
    private val currentUserUseCase: CurrentUserUseCase): NewsLeftContract.Presenter {
    private lateinit var view: NewsLeftContract.View

    override fun setView(view: NewsLeftContract.View) {
        this.view = view
    }

    override fun getNews() {
        indexRssUseCase.execute(::onGetNewsOkResponse, ::onGetNewsFailedResponse)
    }

    override fun insertNews(favouriteNews: FavouriteNews) {
        favouritesDbInteractor.insert(favouriteNews)
    }

    override fun removeFavourite(link: String) {
        favouritesDbInteractor.delete(link)
    }

    override fun getCurrentUser(): String {
        return currentUserUseCase.execute()
    }

    private fun getFavouriteNews(): List<FavouriteNews> = favouritesDbInteractor.getAllNews(currentUserUseCase.execute())

    private fun onGetNewsOkResponse(news: RssFeed?) {
        val favourites = getFavouriteNews()
        for(item in news!!.items){
            for(favourite in favourites){
                if(favourite.link == item.link){
                    item.isFavourite = true
                }
            }
        }
        view.onGetNewsSuccessful(news)
    }

    private fun onGetNewsFailedResponse() = view.onGetNewsFailed()
}