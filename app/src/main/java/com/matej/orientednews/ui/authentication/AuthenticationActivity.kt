package com.matej.orientednews.ui.authentication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.matej.orientednews.R
import com.matej.orientednews.common.showFragment
import com.matej.orientednews.ui.authentication.login.LoginFragment

class AuthenticationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authentication)

        showFragment(R.id.authFragmentContainer,
            LoginFragment.newInstance()
        )
    }
}
