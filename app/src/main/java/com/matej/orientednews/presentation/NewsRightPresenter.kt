package com.matej.orientednews.presentation

import com.matej.orientednews.domain.favourites.FavouritesDbInteractor
import com.matej.orientednews.domain.login.CurrentUserUseCase
import com.matej.orientednews.domain.news.KamenjarRssUseCase
import com.matej.orientednews.model.favourites.FavouriteNews
import com.matej.orientednews.model.rss.RssFeed
import com.matej.orientednews.ui.news.newsList.rightNews.NewsRightContract

class NewsRightPresenter(
    private val kamenjarRssUseCase: KamenjarRssUseCase,
    private val favouritesDbInteractor: FavouritesDbInteractor,
    private val currentUserUseCase: CurrentUserUseCase) : NewsRightContract.Presenter {

    private lateinit var view: NewsRightContract.View

    override fun setView(view: NewsRightContract.View) {
        this.view = view
    }

    override fun getNews() {
        kamenjarRssUseCase.execute(::onGetNewsOkResponse, ::onGetNewsFailedResponse)
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