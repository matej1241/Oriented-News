package com.matej.orientednews.domain.registration

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import com.matej.orientednews.common.ErrorLambda
import com.matej.orientednews.common.SuccessLambda
import com.matej.orientednews.model.authentication.UserDataRequest

class RegisterUseCaseImpl(private val auth: FirebaseAuth): RegisterUseCase {
    override fun execute(body: UserDataRequest, onSuccess: SuccessLambda<Task<AuthResult>>, onFailure: ErrorLambda<Task<AuthResult>>){
        auth.createUserWithEmailAndPassword(body.email, body.password).addOnCompleteListener {
                if (it.isComplete && it.isSuccessful){
                    auth.currentUser?.updateProfile(UserProfileChangeRequest
                        .Builder()
                        .setDisplayName(body.username)
                        .build())
                    it.run(onSuccess)
                }else{
                    it.run(onFailure)
                }
            }
    }
}