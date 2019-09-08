package com.matej.orientednews.domain.login

import com.google.firebase.auth.FirebaseAuth

class CurrentUserUseCaseImpl(private val auth: FirebaseAuth): CurrentUserUseCase {
    override fun execute(): String {
        val currentUser = auth.currentUser
        if(currentUser != null){
            return currentUser.email.toString()
        }else{
            return "none"
        }
    }
}