package com.matej.orientednews.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.matej.orientednews.model.favourites.FavouriteNews

@Dao
interface FavouritesDao {
    @Insert
    fun insertNews(favouriteNews: FavouriteNews)

    @Query("SELECT * FROM favourites ORDER BY id DESC")
    fun getAllNews(): List<FavouriteNews>

}