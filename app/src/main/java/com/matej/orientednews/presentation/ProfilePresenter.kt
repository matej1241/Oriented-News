package com.matej.orientednews.presentation

import android.graphics.Color
import android.util.Log
import com.matej.orientednews.common.INDEX
import com.matej.orientednews.common.KAMENJAR
import com.matej.orientednews.domain.favourites.FavouritesDbInteractor
import com.matej.orientednews.domain.login.CurrentUserUseCase
import com.matej.orientednews.domain.logout.LogoutUseCase
import com.matej.orientednews.model.favourites.FavouriteNews
import com.matej.orientednews.ui.news.profile.ProfileContract
import lecho.lib.hellocharts.model.SliceValue

class ProfilePresenter(
    private val favouritesDbInteractor: FavouritesDbInteractor,
    private val currentUserUseCase: CurrentUserUseCase,
    private val logoutUseCase: LogoutUseCase): ProfileContract.Presenter {
    private lateinit var view: ProfileContract.View

    override fun setView(view: ProfileContract.View) {
        this.view = view
    }

    override fun getChartData() {
        val data = favouritesDbInteractor.getAllNews(currentUserUseCase.execute())
        calculateChartData(data)
    }

    override fun getCurrentUser(): String = currentUserUseCase.execute()

    override fun signOut() {
        logoutUseCase.execute(::onSignOutSuccessful)
    }

    private fun calculateChartData(data: List<FavouriteNews>) {
        var leftNewsCount = 0
        var rightNewsCount = 0
        for (news in data){
            if (news.source == INDEX) leftNewsCount++
            if (news.source == KAMENJAR) rightNewsCount++
        }
        if(leftNewsCount == 0 && rightNewsCount == 0) onCalculateChartDataFailed()
        else onCalculateChartDataSuccessful(Pair(leftNewsCount, rightNewsCount))
    }

    private fun onCalculateChartDataSuccessful(chartData: Pair<Int, Int>) {
        val data: MutableList<SliceValue> = mutableListOf()
        data.add(SliceValue(chartData.first.toFloat(), Color.RED).setLabel(chartData.first.toString() + " left"))
        data.add(SliceValue(chartData.second.toFloat(), Color.BLUE).setLabel(chartData.second.toString() + " right"))
        view.onGetChartDataSuccessful(data)
    }

    private fun onCalculateChartDataFailed() = view.onGetChartDataFailed()

    private fun onSignOutSuccessful() = view.onSignOutSuccessful()
}