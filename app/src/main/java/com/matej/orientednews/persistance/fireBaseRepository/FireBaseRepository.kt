package com.matej.orientednews.persistance.fireBaseRepository

import com.google.firebase.auth.FirebaseAuth

interface FireBaseRepository {
    fun getAuth(): FirebaseAuth
}