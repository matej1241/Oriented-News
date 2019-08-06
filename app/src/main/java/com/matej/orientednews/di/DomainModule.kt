package com.matej.orientednews.di

import com.matej.orientednews.domain.login.RegisterUseCase
import com.matej.orientednews.domain.login.RegisterUseCaseImpl
import com.matej.orientednews.domain.registration.LoginUseCase
import com.matej.orientednews.domain.registration.LoginUseCaseImpl
import org.koin.dsl.module

val domainModule = module {
    factory<RegisterUseCase> { RegisterUseCaseImpl(get()) }
    factory<LoginUseCase> { LoginUseCaseImpl(get()) }
}