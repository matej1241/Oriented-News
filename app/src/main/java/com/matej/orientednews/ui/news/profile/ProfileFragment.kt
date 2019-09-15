package com.matej.orientednews.ui.news.profile


import android.graphics.Color
import android.util.Log
import androidx.fragment.app.Fragment

import com.matej.orientednews.R
import com.matej.orientednews.ui.authentication.AuthenticationActivity
import com.matej.orientednews.ui.base.BaseFragment
import com.matej.orientednews.ui.news.NewsActivity
import kotlinx.android.synthetic.main.fragment_profile.*
import lecho.lib.hellocharts.model.PieChartData
import lecho.lib.hellocharts.model.SliceValue
import org.koin.android.ext.android.inject

class ProfileFragment : BaseFragment(), ProfileContract.View {
    private val presenter: ProfileContract.Presenter by inject()

    override fun getLayoutResourceId(): Int = R.layout.fragment_profile

    override fun setupUi() {
        presenter.setView(this)
        setUserProfileName()
        getChartData()
    }

    override fun setOnClickListeners() {
        logOutText.setOnClickListener { onSignOutClicked() }
    }

    private fun setUserProfileName() {
        userNameText.text = presenter.getCurrentUser()
    }

    private fun getChartData() {
        presenter.getChartData()
    }

    private fun onSignOutClicked() {
        presenter.signOut()
    }

    override fun onSignOutSuccessful() {
        startActivity(AuthenticationActivity::class.java)
    }

    override fun onGetChartDataSuccessful(chartData: List<SliceValue>) {
        val pieChartData = PieChartData(chartData)
        pieChartData.setHasCenterCircle(true)
        pieChartData.setHasLabels(true)
        pieChart.pieChartData = pieChartData
    }

    override fun onGetChartDataFailed() {
        Log.d("Tag'''", "No chart data")
    }

    companion object {
        fun newInstance(): Fragment {
            return ProfileFragment()
        }
    }
}
