package com.matej.orientednews.presentation

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.matej.orientednews.domain.registration.LoginUseCase
import com.matej.orientednews.model.UserDataRequest
import com.matej.orientednews.ui.authentication.login.LoginContract

class LoginPresenter(private val loginUseCase: LoginUseCase): LoginContract.Presenter {

    private lateinit var view: LoginContract.View

    override fun setView(view: LoginContract.View) {
        this.view = view
    }

    override fun onLoginClicked(userDataRequest: UserDataRequest) {
        loginUseCase.execute(userDataRequest, ::onLoginOkResponse, ::onLoginFailedResponse)
    }

    private fun onLoginOkResponse(response: Task<AuthResult>) = view.onLoginSuccessful()

    private fun onLoginFailedResponse(response: Task<AuthResult>) = view.onLoginFailed()
}