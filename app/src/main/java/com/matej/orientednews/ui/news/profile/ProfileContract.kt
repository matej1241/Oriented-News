package com.matej.orientednews.ui.news.profile

import lecho.lib.hellocharts.model.SliceValue

interface ProfileContract {

    interface View{
        fun onGetChartDataSuccessful(chartData: List<SliceValue>)
        fun onGetChartDataFailed()
        fun onSignOutSuccessful()
    }

    interface Presenter{
        fun setView(view: View)
        fun getChartData()
        fun getCurrentUser(): String
        fun signOut()
    }
}