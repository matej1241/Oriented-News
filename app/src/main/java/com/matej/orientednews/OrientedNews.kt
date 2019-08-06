package com.matej.orientednews

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.matej.orientednews.di.domainModule
import com.matej.orientednews.di.firebaseModule
import com.matej.orientednews.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class OrientedNews: Application() {
    companion object{
        lateinit var instance: OrientedNews
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        startKoin {
            modules(listOf(domainModule, firebaseModule, presentationModule))
            androidContext(this@OrientedNews)
        }
    }
}