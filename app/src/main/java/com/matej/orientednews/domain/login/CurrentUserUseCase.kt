package com.matej.orientednews.domain.login

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.matej.orientednews.common.CurrentUserFailed
import com.matej.orientednews.common.CurrentUserSuccess
import com.matej.orientednews.common.ErrorLambda
import com.matej.orientednews.common.SuccessLambda

interface CurrentUserUseCase {
    fun execute(): String
}