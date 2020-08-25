package com.example.completeandroidknowledge.sectionPublic.feature21News.viewMVC

import androidx.fragment.app.FragmentManager
import com.example.completeandroidknowledge.commons.headerStep.StepHeaderFragment
import com.example.completeandroidknowledge.commons.views.ObservableViewMVC
import com.example.completeandroidknowledge.databinding.NewFragmentBinding
import com.example.completeandroidknowledge.sectionPublic.feature21News.viewModel.NewsViewModel

interface NewsFragmentMVCView: ObservableViewMVC<NewsFragmentMVCView.Listener, NewFragmentBinding> {

    interface Listener{
        fun onTakePhotoClicked()
    }
    val binding: NewFragmentBinding
    fun setViewModel(viewModel: NewsViewModel)
    fun startSeptHeader()
}