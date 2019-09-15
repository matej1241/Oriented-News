package com.matej.orientednews.ui.news.favourites


import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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
        presenter.getFavouriteNews(presenter.getCurrentUser())
    }

    override fun setOnClickListeners() {
        swipeToDeleteListener()
    }

    override fun onGetFavouritesSuccessful(favoriteNews: List<FavouriteNews>) {
        adapter.setData(favoriteNews)
    }

    private fun swipeToDeleteListener() {
        val itemTouchCallback = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder
            ): Boolean = false

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                val currentNews = adapter.getCurrentItem(position)
                adapter.removeItem(currentNews)
                presenter.removeFavourite(currentNews.link)
            }
        }
        val itemTouchHelper = ItemTouchHelper(itemTouchCallback)
        itemTouchHelper.attachToRecyclerView(favouritesRecyclerView)
    }

    companion object {
        fun newInstance(): Fragment {
            return FavouritesFragment()
        }
    }
}
