package com.matej.orientednews.domain.login

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.matej.orientednews.common.ErrorLambda
import com.matej.orientednews.common.SuccessLambda
import com.matej.orientednews.model.authentication.UserDataRequest

class LoginUseCaseImpl(private val auth: FirebaseAuth): LoginUseCase {
    override fun execute(body: UserDataRequest, onSuccess: SuccessLambda<Task<AuthResult>>, onFailure: ErrorLambda<Task<AuthResult>>) {
        auth.signInWithEmailAndPassword(body.email, body.password).addOnCompleteListener {
            if (it.isComplete && it.isSuccessful){
                it.run(onSuccess)
            }else{
                it.run(onFailure)
            }
        }
    }
}