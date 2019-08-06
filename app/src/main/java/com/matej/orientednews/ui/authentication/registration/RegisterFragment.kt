package com.matej.orientednews.ui.authentication.registration


import android.widget.Toast
import androidx.fragment.app.Fragment
import com.matej.orientednews.OrientedNews

import com.matej.orientednews.R
import com.matej.orientednews.common.showFragment
import com.matej.orientednews.model.UserDataRequest
import com.matej.orientednews.ui.authentication.login.LoginFragment
import com.matej.orientednews.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_registration.*
import org.koin.android.ext.android.inject

class RegisterFragment : BaseFragment(), RegisterContract.View {

    private val presenter: RegisterContract.Presenter by inject<RegisterContract.Presenter> ()

    override fun getLayoutResourceId(): Int = R.layout.fragment_registration

    override fun setupUi() {
        presenter.setView(this)
    }

    override fun setOnClickListeners() {
        loginInsteadText.setOnClickListener { onSignUpClicked() }
        registerButton.setOnClickListener{ onRegisterClicked() }
    }

    private fun onRegisterClicked() {
        presenter.onRegisterClicked(UserDataRequest(
            regEmail.text.toString(),
            regUsername.text.toString(),
            regPassword.text.toString()
            )
        )
    }

    private fun onSignUpClicked() {
        activity?.showFragment(R.id.authFragmentContainer, LoginFragment.newInstance())
    }

    override fun onRegisterSuccessful() {
        Toast.makeText(OrientedNews.instance, "Korisnik uspijesno registriran", Toast.LENGTH_SHORT).show()
    }

    override fun onRegisterFailed() {
        Toast.makeText(OrientedNews.instance, "Pogreska", Toast.LENGTH_SHORT).show()
    }

    companion object {
        fun newInstance(): Fragment {
            return RegisterFragment()
        }
    }
}
