package com.example.completeandroidknowledge.sectionPublic.feature21News.uiControl

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.completeandroidknowledge.commons.controllers.BaseFragmentPublic
import com.example.completeandroidknowledge.sectionPublic.feature21News.viewMVC.NewsFragmentMVCView
import com.example.completeandroidknowledge.sectionPublic.feature21News.viewModel.NewsFragmentViewModel

class NewsFragmentPublic: BaseFragmentPublic() {

    private lateinit var newsFragmentMVCView: NewsFragmentMVCView
    private lateinit var viewModel: NewsFragmentViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        newsFragmentMVCView = getCompositionRootObject().getViewMVCFactory().getNewsFragmentMVCView(container)
        viewModel = ViewModelProvider(this).get(NewsFragmentViewModel::class.java)

        return newsFragmentMVCView.getRootView()
    }
}