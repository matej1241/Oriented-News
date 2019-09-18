package com.matej.orientednews.di

import com.matej.orientednews.presentation.*
import com.matej.orientednews.ui.authentication.login.LoginContract
import com.matej.orientednews.ui.authentication.registration.RegisterContract
import com.matej.orientednews.ui.news.favourites.FavouritesContract
import com.matej.orientednews.ui.news.newsList.leftNews.NewsLeftContract
import com.matej.orientednews.ui.news.newsList.rightNews.NewsRightContract
import com.matej.orientednews.ui.news.profile.ProfileContract
import org.koin.dsl.module

val presentationModule = module {
    factory <RegisterContract.Presenter>{ RegisterPresenter(get()) }
    factory <LoginContract.Presenter>{ LoginPresenter(get(), get()) }
    factory <NewsLeftContract.Presenter>{NewsLeftPresenter(get(), get(), get())}
    factory <NewsRightContract.Presenter>{ NewsRightPresenter(get(), get(), get()) }
    factory <FavouritesContract.Presenter> { FavouritesPresenter(get(), get()) }
    factory <ProfileContract.Presenter> { ProfilePresenter(get(), get(), get()) }
}