package com.matej.orientednews.model.rss

data class Items (
    val title: String,
    val pubDate: String,
    val link: String,
    val guid: String,
    val author: String,
    val thumbnail: String,
    val description: String,
    val content: String,
    val enclosure: Enclosure,
    val category: List<Category>
){
    var isFavourite: Boolean = false
}