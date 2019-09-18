package com.matej.orientednews.ui.authentication.login


import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.matej.orientednews.OrientedNews

import com.matej.orientednews.R
import com.matej.orientednews.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_login.*
import com.matej.orientednews.common.showFragment
import com.matej.orientednews.model.authentication.UserDataRequest
import com.matej.orientednews.ui.authentication.registration.RegisterFragment
import com.matej.orientednews.ui.news.NewsActivity
import org.koin.android.ext.android.inject

class LoginFragment : BaseFragment(), LoginContract.View {

    private val presenter: LoginContract.Presenter by inject<LoginContract.Presenter>()

    override fun getLayoutResourceId(): Int = R.layout.fragment_login

    override fun setupUi() {
        loginProgress.visibility = View.GONE
        presenter.setView(this)
        if(presenter.getCurrentUser() != "null"){
            startActivity(NewsActivity::class.java)
        }
    }

    override fun setOnClickListeners() {
        createNewAccountText.setOnClickListener{ onSignUpClicked()}
        loginButton.setOnClickListener{ onLoginClicked() }
    }

    private fun onLoginClicked() {
        loginProgress.visibility = View.VISIBLE
        presenter.onLoginClicked(
            UserDataRequest(
                email = authEmail.text.toString(),
                password = authPassword.text.toString()
            )
        )
    }

    private fun onSignUpClicked() {
        activity?.showFragment(R.id.authFragmentContainer, RegisterFragment.newInstance())
    }

    override fun onLoginSuccessful() {
        loginProgress.visibility = View.GONE
        startActivity(NewsActivity::class.java)
    }

    override fun onLoginFailed() {
        loginProgress.visibility = View.GONE
        Toast.makeText(OrientedNews.instance, "Pogreska", Toast.LENGTH_SHORT).show()
    }

    companion object {
        fun newInstance(): Fragment {
            return LoginFragment()
        }
    }
}
