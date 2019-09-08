package com.matej.orientednews.ui.news.profile


import androidx.fragment.app.Fragment

import com.matej.orientednews.R
import com.matej.orientednews.ui.base.BaseFragment

class ProfileFragment : BaseFragment() {

    override fun getLayoutResourceId(): Int = R.layout.fragment_profile

    override fun setupUi() {
    }

    override fun setOnClickListeners() {
    }

    companion object {
        fun newInstance(): Fragment {
            return ProfileFragment()
        }
    }
}
