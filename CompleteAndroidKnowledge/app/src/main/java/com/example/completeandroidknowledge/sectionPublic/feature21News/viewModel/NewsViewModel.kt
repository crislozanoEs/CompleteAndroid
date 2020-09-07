package com.example.completeandroidknowledge.sectionPublic.feature21News.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.completeandroidknowledge.commons.dialogs.DialogEventBus
import com.example.completeandroidknowledge.commons.dialogs.DialogManager
import com.example.completeandroidknowledge.commons.dialogs.optionsDialog.OptionDialogEvent
import com.example.completeandroidknowledge.sectionPublic.feature21News.utilities.CustomImageAnalyzer
import com.google.mlkit.vision.label.ImageLabel

class NewsViewModel(private var customImageAnalyzer: CustomImageAnalyzer,
                    private val dialogManager: DialogManager,
                    private val dialogEventBus: DialogEventBus):
    ViewModel(), CustomImageAnalyzer.Listener, DialogEventBus.Listener {

    enum class STATE{
        STEP_1, STEP_2,STEP_3, STEP_1_ERROR, STEP_LIST_ERROR
    }
    enum class MOVEMENT{
        STAY, FORWARD,BACKWARD
    }

    private val _currentState = MutableLiveData<STATE>()
    val currentState: LiveData<STATE>
        get() = _currentState

    private val _movement = MutableLiveData<MOVEMENT>()
    val movement: LiveData<MOVEMENT>
        get() = _movement

    private val THRESHOLD = 0.7f

    private val _listTag = MutableLiveData<List<String>>()
    val listTag: LiveData<List<String>>
        get() = _listTag

    init{
        _movement.value = MOVEMENT.STAY
        _currentState.value = STATE.STEP_1
        customImageAnalyzer.registerListener(this)
        dialogEventBus.registerListener(this)
    }
    override fun onCleared() {
        customImageAnalyzer.unregisterListener(this)
        dialogEventBus.unregisterListener(this)
        super.onCleared()
    }

    override fun onAnalysisSucceed(list: List<ImageLabel>) {
        _listTag.value = list.filter { it.confidence > THRESHOLD}.map { it.text }
        var stringTags = ""
        _listTag.value?.forEach {
            stringTags = "$stringTags, $it"
        }
        dialogManager.showErrorOnlyTwoAction(null,"Find the product tag below","Tags:\n $stringTags", "Found it!", "Wrong")
    }

    override fun onCameraError() {
        onErrorStep1()
    }

    override fun onCaptureImageError() {
        onErrorStep1()
    }

    override fun onAnalysisError() {
        onErrorStep1()
    }

    private fun onErrorStep1(){
        _movement.value = MOVEMENT.STAY
        _currentState.value = STATE.STEP_1_ERROR
    }

    override fun onDialogEvent(event: Any) {
        if(event is OptionDialogEvent){
            when(event.getClickedButton()){
                OptionDialogEvent.Button.POSITIVE -> goToStep2()
                OptionDialogEvent.Button.NEGATIVE -> stayStep1()
            }
        }
    }

    private fun stayStep1() {
        _movement.value = MOVEMENT.STAY
    }

    private fun goToStep2() {
        _movement.value = MOVEMENT.FORWARD
        _currentState.value = STATE.STEP_2
    }

}