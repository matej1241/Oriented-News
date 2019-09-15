package com.matej.orientednews.di

import com.matej.orientednews.persistance.dbRepository.FavouritesRepository
import com.matej.orientednews.persistance.dbRepository.FavouritesRepositoryImpl
import com.matej.orientednews.persistance.fireBaseRepository.FireBaseRepository
import com.matej.orientednews.persistance.fireBaseRepository.FireBaseRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    factory<FavouritesRepository> { FavouritesRepositoryImpl(get()) }
    factory<FireBaseRepository> { FireBaseRepositoryImpl(get()) }
}