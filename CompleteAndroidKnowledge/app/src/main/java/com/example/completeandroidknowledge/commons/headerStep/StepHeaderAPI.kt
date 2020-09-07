package com.example.completeandroidknowledge.commons.headerStep

import android.util.Log

object StepHeaderAPI {

    private lateinit var viewModel: StepHeaderViewModel

    fun setViewModel(viewModel: StepHeaderViewModel){
        this.viewModel = viewModel
    }

    fun goForward(){
        Log.i("STEP","goForward")
        viewModel.goForwardVM()
    }
    fun goBackward(){
        Log.i("STEP","goForward")
        viewModel.goBackwardVM()
    }

}