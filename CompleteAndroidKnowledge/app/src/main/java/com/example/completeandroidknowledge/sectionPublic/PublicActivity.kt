package com.example.completeandroidknowledge.sectionPublic

import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.completeandroidknowledge.R
import com.example.completeandroidknowledge.commons.Constants
import com.example.completeandroidknowledge.commons.controllers.BaseActivity
import com.example.completeandroidknowledge.commons.navigation.NavigationActivity

class PublicActivity : BaseActivity(),PublicActivityMVCView.Listener {

    private lateinit var activityMVCViewImpl: PublicActivityMVCViewImpl
    private lateinit var navigationActivity: NavigationActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMVCViewImpl = activityCompositionRoot!!.getActivityMVCView(this)
        val navController =  this.findNavController(R.id.insert_point)
        super.setNavController(navController)
        navigationActivity = activityCompositionRoot!!.getNavigationActivity()
        NavigationUI.setupActionBarWithNavController(this, navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return activityCompositionRoot!!.navController!!.navigateUp()
    }

    override fun onStart() {
        activityMVCViewImpl.registerListener(this)
        super.onStart()
    }

    override fun onStop() {
        activityMVCViewImpl.unregisterListener(this)
        super.onStop()
    }

    override fun onFooterClicked(selected: Constants.Companion.FOOTER) {
        when(selected){
            Constants.Companion.FOOTER.HOME -> navigationActivity.updateOnHomeClicked()
            Constants.Companion.FOOTER.PRODUCTS_INFO -> navigationActivity.updateOnProductsInfoClicked()
            Constants.Companion.FOOTER.NEWS -> navigationActivity.updateOnNewsClicked()
            else -> navigationActivity.updateOnHomeClicked()
        }
    }
}
