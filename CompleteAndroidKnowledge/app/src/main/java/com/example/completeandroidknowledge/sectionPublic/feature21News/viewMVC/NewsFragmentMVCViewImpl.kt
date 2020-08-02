package com.example.completeandroidknowledge.sectionPublic.feature21News.viewMVC

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import com.example.completeandroidknowledge.R
import com.example.completeandroidknowledge.commons.views.ObservableViewMVCImpl
import com.example.completeandroidknowledge.databinding.NewFragmentBinding
import com.example.completeandroidknowledge.sectionPublic.feature21News.viewModel.NewsFragmentViewModel

class NewsFragmentMVCViewImpl(inflater: LayoutInflater, parent: ViewGroup?): NewsFragmentMVCView,
    ObservableViewMVCImpl<NewsFragmentMVCView.Listener, NewFragmentBinding>() {

    override val binding: NewFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.new_fragment, parent, false)


    init{
        setRootView(binding.root)
    }
    override fun setViewModel(viewModel: NewsFragmentViewModel) {
        TODO("Not yet implemented")
    }

    override fun setLifecycleOwner(owner: LifecycleOwner) {
        binding.lifecycleOwner = owner
    }


}