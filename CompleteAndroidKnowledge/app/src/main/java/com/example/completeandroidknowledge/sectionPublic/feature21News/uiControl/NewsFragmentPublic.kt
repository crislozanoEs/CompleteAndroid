package com.example.completeandroidknowledge.sectionPublic.feature21News.uiControl

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.completeandroidknowledge.commons.controllers.BaseFragmentPublic
import com.example.completeandroidknowledge.commons.navigation.NavigationActivity
import com.example.completeandroidknowledge.sectionPublic.feature21News.viewMVC.NewsFragmentMVCView
import com.example.completeandroidknowledge.sectionPublic.feature21News.viewModel.NewsFragmentViewModel

class NewsFragmentPublic: BaseFragmentPublic(), NavigationActivity.Listener {

    private lateinit var newsFragmentMVCView: NewsFragmentMVCView
    private lateinit var viewModel: NewsFragmentViewModel
    private lateinit var navigationActivity: NavigationActivity
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        newsFragmentMVCView = getCompositionRootObject().getViewMVCFactory().getNewsFragmentMVCView(container)
        navigationActivity = getCompositionRootObject().getMainNavigation()
        viewModel = ViewModelProvider(this).get(NewsFragmentViewModel::class.java)

        return newsFragmentMVCView.getRootView()
    }

    override fun onStart() {
        navigationActivity.registerListener(this)
        super.onStart()
    }

    override fun onStop() {
        navigationActivity.unregisterListener(this)
        super.onStop()
    }

    override fun onHomeClicked() {
        navigationActivity.fromNewsToHome()
    }

    override fun onProductsInfoClicked() {
        navigationActivity.fromNewsToProductsInfo()
    }

    override fun onNewsClicked() {
        //Not needed of moving
    }
}