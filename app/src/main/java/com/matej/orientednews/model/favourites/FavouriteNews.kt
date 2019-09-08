package com.matej.orientednews.model.favourites

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favourites")
data class FavouriteNews (
    @PrimaryKey(autoGenerate = true) var id: Long = 0,
    @ColumnInfo(name = "user") val user: String,
    @ColumnInfo(name = "source") val source: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "link") val link: String,
    @ColumnInfo(name = "thumbnail") val thumbnail: String,
    @ColumnInfo(name = "feed") val feed: String
)