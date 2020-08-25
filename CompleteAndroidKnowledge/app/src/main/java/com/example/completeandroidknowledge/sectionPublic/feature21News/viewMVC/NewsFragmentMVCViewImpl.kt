package com.example.completeandroidknowledge.sectionPublic.feature21News.viewMVC

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.LifecycleOwner
import com.example.completeandroidknowledge.R
import com.example.completeandroidknowledge.commons.controllers.BaseFragmentTransactional
import com.example.completeandroidknowledge.commons.headerStep.StepHeaderFragment
import com.example.completeandroidknowledge.commons.views.ObservableViewMVCImpl
import com.example.completeandroidknowledge.databinding.NewFragmentBinding
import com.example.completeandroidknowledge.sectionPublic.feature21News.viewModel.NewsViewModel

class NewsFragmentMVCViewImpl(
    inflater: LayoutInflater,
    parent: ViewGroup?,
    private val headerFragment: StepHeaderFragment,
    private val fragmentManager: FragmentManager
): NewsFragmentMVCView,
    ObservableViewMVCImpl<NewsFragmentMVCView.Listener, NewFragmentBinding>() {

    override val binding: NewFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.new_fragment, parent, false)


    init{
        binding.btnTakePicture.setOnClickListener{
            Log.i("CameraX","Publishing to listener")
            getListener().forEach{
                it.onTakePhotoClicked()
            }
        }
        setRootView(binding.root)
    }
    override fun setViewModel(viewModel: NewsViewModel) {
        TODO("Not yet implemented")
    }

    override fun startSeptHeader() {
        fragmentManager.beginTransaction().replace(binding.stepHeader.id, headerFragment).commitAllowingStateLoss()
    }

    override fun setLifecycleOwner(owner: LifecycleOwner) {
        binding.lifecycleOwner = owner
    }



}