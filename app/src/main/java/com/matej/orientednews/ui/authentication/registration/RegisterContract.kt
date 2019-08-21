package com.matej.orientednews.ui.authentication.registration

import com.matej.orientednews.model.authentication.UserDataRequest

interface RegisterContract {

    interface View{
        fun onRegisterSuccessful()
        fun onRegisterFailed()
    }

    interface Presenter{
        fun setView(view: View)
        fun onRegisterClicked(user: UserDataRequest)
    }
}