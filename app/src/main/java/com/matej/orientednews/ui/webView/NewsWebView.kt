package com.matej.orientednews.ui.webView

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import com.matej.orientednews.R
import com.matej.orientednews.ui.base.BaseActivity

import kotlinx.android.synthetic.main.activity_news_web_view.*

class NewsWebView : BaseActivity() {

    override fun getLayoutResourceId(): Int = R.layout.activity_news_web_view

    override fun setupUi() {
        val url = intent.getStringExtra(WEB_URL)
        val newsWebView: WebView = findViewById(R.id.newsWebView)
        newsWebView.webViewClient = WebViewClient()
        newsWebView.settings.javaScriptEnabled = true
        newsWebView.loadUrl(url)
    }

    companion object{
        const val WEB_URL = "Url"
    }
}
