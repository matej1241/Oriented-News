package com.matej.orientednews.model.authentication

data class UserDataRequest(val email: String, val username: String = "", val password: String)