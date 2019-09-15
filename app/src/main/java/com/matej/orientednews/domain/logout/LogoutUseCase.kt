package com.matej.orientednews.domain.logout



import com.matej.orientednews.common.LogoutSuccess
import com.matej.orientednews.model.authentication.UserDataRequest

interface LogoutUseCase {
    fun execute(onSuccess: LogoutSuccess)
}