package com.matej.orientednews.ui.news.newsList


import androidx.fragment.app.Fragment

import com.matej.orientednews.R
import com.matej.orientednews.ui.base.BaseFragment
import com.matej.orientednews.ui.news.adapter.NewsPagerAdapter
import kotlinx.android.synthetic.main.fragment_news_container.*


class NewsContainerFragment : BaseFragment() {

    override fun getLayoutResourceId(): Int = R.layout.fragment_news_container

    override fun setupUi() {
        viewPager.adapter = NewsPagerAdapter(activity!!.supportFragmentManager)
        tabLayout.setupWithViewPager(viewPager)
    }

    override fun setOnClickListeners() {
    }

    companion object {
        fun newInstance(): Fragment {
            return NewsContainerFragment()
        }
    }
}
