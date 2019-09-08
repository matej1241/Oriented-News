package com.matej.orientednews.di

import androidx.room.Room
import com.matej.orientednews.OrientedNews
import com.matej.orientednews.db.FavouritesDaoProvider
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(
            OrientedNews.instance,
            FavouritesDaoProvider::class.java,
            "favorites_database")
            .allowMainThreadQueries().build() }

    single { get<FavouritesDaoProvider>().favouritesDao() }
}