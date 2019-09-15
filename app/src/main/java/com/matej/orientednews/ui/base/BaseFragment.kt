package com.matej.orientednews.ui.base

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.matej.orientednews.OrientedNews
import com.matej.orientednews.common.showFragment
import com.matej.orientednews.ui.news.NewsActivity

abstract class BaseFragment: Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayoutResourceId(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUi()
        setOnClickListeners()
    }

    protected fun startActivity(newActivity: Class<*>){
        val intent = Intent(OrientedNews.instance, newActivity)
        startActivity(intent)
    }

    abstract fun getLayoutResourceId(): Int
    abstract fun setupUi()
    abstract fun setOnClickListeners()
}