package com.matej.orientednews.domain.logout

import com.google.firebase.auth.FirebaseAuth
import com.matej.orientednews.common.LogoutSuccess
import com.matej.orientednews.model.authentication.UserDataRequest
import com.matej.orientednews.persistance.fireBaseRepository.FireBaseRepository

class LogoutUseCaseImpl(private val authRepository: FireBaseRepository): LogoutUseCase {
    override fun execute(onSuccess: LogoutSuccess) {
        authRepository.getAuth().signOut()
        run(onSuccess)
    }
}