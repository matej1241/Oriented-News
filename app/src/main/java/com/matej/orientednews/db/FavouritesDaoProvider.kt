package com.matej.orientednews.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.matej.orientednews.model.favourites.FavouriteNews

@Database(entities = [FavouriteNews::class], version = 1)
abstract class FavouritesDaoProvider: RoomDatabase() {
    abstract fun favouritesDao() : FavouritesDao
}