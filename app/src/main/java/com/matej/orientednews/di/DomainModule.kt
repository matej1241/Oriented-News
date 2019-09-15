package com.matej.orientednews.di

import com.matej.orientednews.domain.favourites.FavouritesDbInteractor
import com.matej.orientednews.domain.favourites.FavouritesDbInteractorImpl
import com.matej.orientednews.domain.login.CurrentUserUseCase
import com.matej.orientednews.domain.login.CurrentUserUseCaseImpl
import com.matej.orientednews.domain.registration.RegisterUseCase
import com.matej.orientednews.domain.registration.RegisterUseCaseImpl
import com.matej.orientednews.domain.news.IndexRssUseCase
import com.matej.orientednews.domain.news.IndexRssUseCaseImpl
import com.matej.orientednews.domain.news.KamenjarRssUseCase
import com.matej.orientednews.domain.news.KamenjarRssUseCaseImpl
import com.matej.orientednews.domain.login.LoginUseCase
import com.matej.orientednews.domain.login.LoginUseCaseImpl
import com.matej.orientednews.domain.logout.LogoutUseCase
import com.matej.orientednews.domain.logout.LogoutUseCaseImpl
import org.koin.dsl.module

val domainModule = module {
    factory<RegisterUseCase> { RegisterUseCaseImpl(get()) }
    factory<LoginUseCase> { LoginUseCaseImpl(get()) }
    factory<CurrentUserUseCase> { CurrentUserUseCaseImpl(get()) }
    factory<IndexRssUseCase> { IndexRssUseCaseImpl(get()) }
    factory<KamenjarRssUseCase> { KamenjarRssUseCaseImpl(get()) }
    factory<FavouritesDbInteractor> { FavouritesDbInteractorImpl(get()) }
    factory<LogoutUseCase> { LogoutUseCaseImpl(get()) }
}