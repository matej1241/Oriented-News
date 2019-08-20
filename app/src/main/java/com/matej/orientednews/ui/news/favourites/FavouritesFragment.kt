package com.matej.orientednews.ui.news.favourites


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.matej.orientednews.R
import com.matej.orientednews.ui.base.BaseFragment
import com.matej.orientednews.ui.news.newsList.NewsFragment

class FavouritesFragment : BaseFragment() {
    override fun getLayoutResourceId(): Int = R.layout.fragment_favourites

    override fun setupUi() {
    }

    override fun setOnClickListeners() {
    }

    companion object {
        fun newInstance(): Fragment {
            return FavouritesFragment()
        }
    }
}
