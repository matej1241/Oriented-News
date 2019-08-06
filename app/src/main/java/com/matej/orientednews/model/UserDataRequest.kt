package com.matej.orientednews.model

data class UserDataRequest(val email: String, val username: String = "", val password: String)