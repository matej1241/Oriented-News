package com.matej.orientednews.di

import com.matej.orientednews.persistance.dbRepository.FavouritesRepository
import com.matej.orientednews.persistance.dbRepository.FavouritesRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    factory<FavouritesRepository> { FavouritesRepositoryImpl(get()) }
}