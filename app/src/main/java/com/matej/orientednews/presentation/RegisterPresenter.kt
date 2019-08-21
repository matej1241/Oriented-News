package com.matej.orientednews.presentation

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.matej.orientednews.domain.login.RegisterUseCase
import com.matej.orientednews.model.authentication.UserDataRequest
import com.matej.orientednews.ui.authentication.registration.RegisterContract

class RegisterPresenter(private val registerUseCase: RegisterUseCase): RegisterContract.Presenter {

    private lateinit var view: RegisterContract.View

    override fun setView(view: RegisterContract.View) {
        this.view = view
    }

    override fun onRegisterClicked(user: UserDataRequest) {
        registerUseCase.execute(user, ::onRegisterOkRespone, ::onRegisterFailedResponse)
    }

    private fun onRegisterOkRespone(response: Task<AuthResult>) = view.onRegisterSuccessful()

    private fun onRegisterFailedResponse(response: Task<AuthResult>) = view.onRegisterFailed()
}