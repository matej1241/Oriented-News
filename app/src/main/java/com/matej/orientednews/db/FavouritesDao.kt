package com.matej.orientednews.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.matej.orientednews.model.favourites.FavouriteNews

@Dao
interface FavouritesDao {
    @Insert
    fun insertNews(favouriteNews: FavouriteNews)

    @Query("SELECT * FROM favourites WHERE user = :user ORDER BY id DESC")
    fun getAllNews(user: String): List<FavouriteNews>

    @Query("DELETE FROM favourites WHERE link = :link")
    fun removeFavourite(link: String)

}