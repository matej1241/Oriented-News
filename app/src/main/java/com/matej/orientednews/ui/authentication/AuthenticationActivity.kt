package com.matej.orientednews.ui.authentication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.matej.orientednews.R
import com.matej.orientednews.common.showFragment
import com.matej.orientednews.ui.authentication.login.LoginFragment
import com.matej.orientednews.ui.base.BaseActivity

class AuthenticationActivity : BaseActivity() {

    override fun getLayoutResourceId(): Int = R.layout.activity_authentication

    override fun setupUi() {
        showFragment(R.id.authFragmentContainer, LoginFragment.newInstance())
    }
}
