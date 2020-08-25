package com.example.completeandroidknowledge.commons.headerStep

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class StepHeaderViewModel: ViewModel(), StepHeaderAPI {
    private var _currentStep = MutableLiveData<Int>()
    val currentState: LiveData<Int>
        get() = _currentStep

    init{
        _currentStep.value = 1
    }
    override fun goForward() {
        _currentStep.value = _currentStep.value?.plus(1)
        if(_currentStep.value!! > 3)
            _currentStep.value = 3
    }

    override fun goBackward() {
        _currentStep.value = _currentStep.value?.minus(1)
        if(_currentStep.value!! < 1)
            _currentStep.value = 1
    }
}