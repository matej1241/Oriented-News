package com.matej.orientednews.common

import com.matej.orientednews.model.rss.Feed
import com.matej.orientednews.model.rss.Items

typealias SuccessLambda<T> = (T) -> Unit
typealias ErrorLambda<T> = (T) -> Unit
typealias IndexErrorLambda = () -> Unit
typealias FavouriteClickListener = (item: Items, feed: Feed) -> Unit
typealias NewsClickListener = (url: String) -> Unit
typealias CurrentUserSuccess = (currentUser: String) -> Unit
typealias CurrentUserFailed = () -> Unit
typealias LogoutSuccess = () -> Unit