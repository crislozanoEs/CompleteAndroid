package com.example.completeandroidknowledge.sectionPublic.feature21News.viewMVC

import com.example.completeandroidknowledge.commons.views.ObservableViewMVC
import com.example.completeandroidknowledge.databinding.NewFragmentBinding
import com.example.completeandroidknowledge.sectionPublic.feature21News.viewModel.NewsFragmentViewModel

interface NewsFragmentMVCView: ObservableViewMVC<NewsFragmentMVCView.Listener, NewFragmentBinding> {

    interface Listener{

    }
    val binding: NewFragmentBinding
    fun setViewModel(viewModel: NewsFragmentViewModel)


}