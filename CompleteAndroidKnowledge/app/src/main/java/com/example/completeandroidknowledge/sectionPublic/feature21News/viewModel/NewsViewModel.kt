package com.example.completeandroidknowledge.sectionPublic.feature21News.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.completeandroidknowledge.sectionPublic.feature21News.utilities.CustomImageAnalyzer
import com.google.mlkit.vision.label.ImageLabel

class NewsViewModel(private var customImageAnalyzer: CustomImageAnalyzer): ViewModel(), CustomImageAnalyzer.Listener {
    enum class STATE{
        STEP_CAMERA, STEP_CAMERA_SUCCEED, STEP_CAMERA_ERROR, STEP_LIST_SUCCEED, STEP_LIST_ERROR
    }
    private val _currentState = MutableLiveData<STATE>()

    val currentState: LiveData<STATE>
        get() = _currentState

    private val THRESHOLD = 0.7f

    private val _listTag = MutableLiveData<List<String>>()
    val listTag: LiveData<List<String>>
        get() = _listTag
    init{
        _currentState.value = STATE.STEP_CAMERA
        customImageAnalyzer.registerListener(this)
    }
    override fun onCleared() {
        customImageAnalyzer.unregisterListener(this)
        super.onCleared()
    }

    override fun onAnalysisSucceed(list: List<ImageLabel>) {
        _currentState.value = STATE.STEP_CAMERA_SUCCEED
        _listTag.value = list.filter { it.confidence > THRESHOLD}.map { it.text }
        Log.i("CameraX","TAGS "+_listTag.value.toString())
    }

    override fun onCameraError() {
        _currentState.value = STATE.STEP_CAMERA_ERROR
    }

    override fun onCaptureImageError() {
        _currentState.value = STATE.STEP_CAMERA_ERROR
    }

    override fun onAnalysisError() {
        _currentState.value = STATE.STEP_CAMERA_ERROR
    }

}