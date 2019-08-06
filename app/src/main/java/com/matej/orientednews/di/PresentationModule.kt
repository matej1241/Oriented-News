package com.matej.orientednews.di

import com.matej.orientednews.presentation.LoginPresenter
import com.matej.orientednews.presentation.RegisterPresenter
import com.matej.orientednews.ui.authentication.login.LoginContract
import com.matej.orientednews.ui.authentication.registration.RegisterContract
import org.koin.dsl.module

val presentationModule = module {
    factory <RegisterContract.Presenter>{ RegisterPresenter(get()) }
    factory <LoginContract.Presenter>{LoginPresenter(get())}
}