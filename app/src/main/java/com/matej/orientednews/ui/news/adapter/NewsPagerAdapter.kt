package com.matej.orientednews.ui.news.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.matej.orientednews.ui.news.newsList.leftNews.NewsLeftFragment
import com.matej.orientednews.ui.news.newsList.rightNews.NewsRightFragment

class NewsPagerAdapter(fragmentManager: FragmentManager): FragmentStatePagerAdapter(fragmentManager) {

    private val fragments = arrayOf(
        NewsLeftFragment.newInstance(),
        NewsRightFragment.newInstance()
    )

    private val titles = arrayOf("Left", "Right")

    override fun getItem(position: Int): Fragment = fragments[position]

    override fun getPageTitle(position: Int): CharSequence? = titles[position]

    override fun getCount(): Int = fragments.size
}