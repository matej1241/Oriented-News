package com.matej.orientednews.domain.registration

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.matej.orientednews.common.ErrorLambda
import com.matej.orientednews.common.SuccessLambda
import com.matej.orientednews.model.authentication.UserDataRequest

interface LoginUseCase {
    fun execute(body: UserDataRequest, onSuccess: SuccessLambda<Task<AuthResult>>, onFailure: ErrorLambda<Task<AuthResult>>)
}