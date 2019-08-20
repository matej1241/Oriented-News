package com.matej.orientednews.ui.news.profile


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.matej.orientednews.R
import com.matej.orientednews.ui.base.BaseFragment
import com.matej.orientednews.ui.news.newsList.NewsFragment

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
