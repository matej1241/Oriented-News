package com.matej.orientednews.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.matej.orientednews.R
import com.matej.orientednews.common.showFragment
import com.matej.orientednews.ui.authentication.login.LoginFragment

abstract class BaseActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResourceId())
        supportActionBar?.hide()
        setupUi()
    }

    abstract fun getLayoutResourceId(): Int
    abstract fun setupUi()
}