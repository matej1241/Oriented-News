package com.matej.orientednews.persistance.fireBaseRepository

import com.google.firebase.auth.FirebaseAuth

class FireBaseRepositoryImpl(private val auth: FirebaseAuth): FireBaseRepository {
    override fun getAuth(): FirebaseAuth = auth
}