package com.example.completeandroidknowledge.commons.headerStep

import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class StepHeaderViewModel: ViewModel() {
    private var _currentStep = MutableLiveData<Int>()
    val currentState: LiveData<Int>
        get() = _currentStep

    init{
        _currentStep.value = 1
    }
    fun goForwardVM() {
        Log.i("STEP","goForward")
        _currentStep.value = _currentStep.value?.plus(1)
        if(_currentStep.value!! > 3)
            _currentStep.value = 3
    }

     fun goBackwardVM() {
         Log.i("STEP","goForward")
        _currentStep.value = _currentStep.value?.minus(1)
        if(_currentStep.value!! < 1)
            _currentStep.value = 1
    }
}