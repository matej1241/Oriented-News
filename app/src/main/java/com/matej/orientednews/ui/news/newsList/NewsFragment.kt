package com.matej.orientednews.ui.news.newsList

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.matej.orientednews.R
import com.matej.orientednews.ui.authentication.registration.RegisterFragment
import com.matej.orientednews.ui.base.BaseFragment

class NewsFragment : BaseFragment() {
    override fun getLayoutResourceId(): Int = R.layout.fragment_news

    override fun setupUi() {
    }

    override fun setOnClickListeners() {
    }

    companion object {
        fun newInstance(): Fragment {
            return NewsFragment()
        }
    }
}
