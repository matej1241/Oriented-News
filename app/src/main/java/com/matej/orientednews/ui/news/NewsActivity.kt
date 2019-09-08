package com.matej.orientednews.ui.news

import com.google.android.material.bottomnavigation.BottomNavigationView
import com.matej.orientednews.R
import com.matej.orientednews.common.showFragment
import com.matej.orientednews.ui.base.BaseActivity
import com.matej.orientednews.ui.news.favourites.FavouritesFragment
import com.matej.orientednews.ui.news.newsList.NewsContainerFragment
import com.matej.orientednews.ui.news.profile.ProfileFragment
import kotlinx.android.synthetic.main.activity_news.*

class NewsActivity : BaseActivity() {

    private val onNavItemSelected  = BottomNavigationView.OnNavigationItemSelectedListener {
        when(it.itemId){
            R.id.news -> {
                showFragment(R.id.newsFragmentContainer, NewsContainerFragment.newInstance())
                return@OnNavigationItemSelectedListener true
            }
            R.id.favourites -> {
                showFragment(R.id.newsFragmentContainer, FavouritesFragment.newInstance())
                return@OnNavigationItemSelectedListener true
            }
            R.id.profile -> {
                showFragment(R.id.newsFragmentContainer,ProfileFragment.newInstance())
                return@OnNavigationItemSelectedListener true
            }
            else -> return@OnNavigationItemSelectedListener false
        }
    }

    override fun getLayoutResourceId(): Int = R.layout.activity_news

    override fun setupUi() {
        showFragment(R.id.newsFragmentContainer, NewsContainerFragment.newInstance())
        setOnClickListeners()
    }

    private fun setOnClickListeners() {
        bottomNavBar.setOnNavigationItemSelectedListener(onNavItemSelected)
    }
}
