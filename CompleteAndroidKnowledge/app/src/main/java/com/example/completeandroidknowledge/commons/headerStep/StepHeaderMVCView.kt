package com.example.completeandroidknowledge.commons.headerStep

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.example.completeandroidknowledge.R
import com.example.completeandroidknowledge.commons.views.ViewMVC
import com.example.completeandroidknowledge.commons.views.ViewMVCImpl
import com.example.completeandroidknowledge.databinding.StepHeaderFragmentBinding

class StepHeaderMVCView(inflater: LayoutInflater, viewGroup: ViewGroup?):
    ViewMVCImpl<StepHeaderFragmentBinding>() {

    val binding: StepHeaderFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.step_header_fragment, viewGroup, false)

    init{
        setRootView(binding.root)
    }

    fun activateFirstStep(){
        binding.stepOne.setColorFilter(ContextCompat.getColor(getContext(), R.color.colorPrimary))
        binding.stepTwo.setColorFilter(ContextCompat.getColor(getContext(), R.color.disabled_button_color))
        binding.stepThree.setColorFilter(ContextCompat.getColor(getContext(), R.color.disabled_button_color))
    }

    fun activateSecondStep(){
        binding.stepOne.setColorFilter(ContextCompat.getColor(getContext(), R.color.colorPrimaryDark))
        binding.stepTwo.setColorFilter(ContextCompat.getColor(getContext(), R.color.colorPrimary))
        binding.stepThree.setColorFilter(ContextCompat.getColor(getContext(), R.color.disabled_button_color))
    }

    fun activateThirdStep(){
        binding.stepOne.setColorFilter(ContextCompat.getColor(getContext(), R.color.colorPrimaryDark))
        binding.stepTwo.setColorFilter(ContextCompat.getColor(getContext(), R.color.colorPrimaryDark))
        binding.stepThree.setColorFilter(ContextCompat.getColor(getContext(), R.color.colorPrimary))
    }
}