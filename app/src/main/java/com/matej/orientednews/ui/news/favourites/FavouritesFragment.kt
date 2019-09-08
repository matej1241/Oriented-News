package com.matej.orientednews.ui.news.favourites


import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.matej.orientednews.R
import com.matej.orientednews.model.favourites.FavouriteNews
import com.matej.orientednews.model.rss.Items
import com.matej.orientednews.ui.base.BaseFragment
import com.matej.orientednews.ui.news.adapter.FavouriteNewsAdapter
import com.matej.orientednews.ui.news.adapter.NewsAdapter
import kotlinx.android.synthetic.main.fragment_favourites.*
import org.koin.android.ext.android.inject

class FavouritesFragment : BaseFragment(), FavouritesContract.View {

    private val presenter: FavouritesContract.Presenter by inject()
    private val adapter by lazy { FavouriteNewsAdapter() }

    override fun getLayoutResourceId(): Int = R.layout.fragment_favourites

    override fun setupUi() {
        presenter.setView(this)
        favouritesRecyclerView.layoutManager = LinearLayoutManager(context)
        favouritesRecyclerView.adapter = adapter
        getFavourites()
    }

    private fun getFavourites() {
        val news = presenter.getFavouriteNews()
        adapter.setData(news)
    }

    override fun setOnClickListeners() {
    }

    override fun onGetFavouritesSuccessful(favoriteNews: List<FavouriteNews>) {
    }

    override fun onGetFavouritesFailed() {
    }

    override fun onGetCurrentUserSuccessful(currentUser: String) {
    }

    override fun onGetCurrentUserFailed() {
    }

    companion object {
        fun newInstance(): Fragment {
            return FavouritesFragment()
        }
    }
}
