package com.matej.orientednews.ui.authentication.login

import com.matej.orientednews.model.authentication.UserDataRequest

interface LoginContract {

    interface View{
        fun onLoginSuccessful()
        fun onLoginFailed()
    }

    interface Presenter{
        fun setView(view: View)
        fun onLoginClicked(userDataRequest: UserDataRequest)
        fun getCurrentUser(): String?
    }
}