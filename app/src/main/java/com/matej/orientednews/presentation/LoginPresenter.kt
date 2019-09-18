package com.matej.orientednews.presentation

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.matej.orientednews.domain.login.CurrentUserUseCase
import com.matej.orientednews.domain.login.LoginUseCase
import com.matej.orientednews.model.authentication.UserDataRequest
import com.matej.orientednews.ui.authentication.login.LoginContract

class LoginPresenter(
    private val loginUseCase: LoginUseCase,
    private val getCurrentUserUseCase: CurrentUserUseCase): LoginContract.Presenter {

    private lateinit var view: LoginContract.View

    override fun setView(view: LoginContract.View) {
        this.view = view
    }

    override fun onLoginClicked(userDataRequest: UserDataRequest) {
        loginUseCase.execute(userDataRequest, ::onLoginOkResponse, ::onLoginFailedResponse)
    }

    override fun getCurrentUser(): String? = getCurrentUserUseCase.execute()

    private fun onLoginOkResponse(response: Task<AuthResult>) = view.onLoginSuccessful()

    private fun onLoginFailedResponse(response: Task<AuthResult>) = view.onLoginFailed()
}