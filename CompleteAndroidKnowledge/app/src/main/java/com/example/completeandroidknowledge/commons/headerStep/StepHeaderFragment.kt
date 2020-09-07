package com.example.completeandroidknowledge.commons.headerStep

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.completeandroidknowledge.commons.controllers.BaseFragmentPublic

class StepHeaderFragment: BaseFragmentPublic() {

    private lateinit var mvcView: StepHeaderMVCView
    private lateinit var viewModel: StepHeaderViewModel
    private var stepHeaderAPI = StepHeaderAPI
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mvcView = getCompositionRootObject().getViewMVCFactory().getStepHeaderMVCView(container)
        viewModel = ViewModelProvider(this).get(StepHeaderViewModel::class.java)
        mvcView.setLifecycleOwner(this)
        stepHeaderAPI.setViewModel(viewModel)
        changeStep(viewModel.currentState.value!!)
        viewModel.currentState.observe(viewLifecycleOwner, Observer {
            changeStep(it)
        })
        return mvcView.getRootView()
    }

    private fun changeStep(currentStep: Int){
        when (currentStep){
            1 -> mvcView.activateFirstStep()
            2 -> mvcView.activateSecondStep()
            3 -> mvcView.activateThirdStep()
        }
    }
}