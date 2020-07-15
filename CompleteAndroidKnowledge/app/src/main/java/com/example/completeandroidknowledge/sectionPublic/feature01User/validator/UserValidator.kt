package com.example.completeandroidknowledge.sectionPublic.feature01User.validator

import android.text.Editable
import android.text.TextUtils
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.completeandroidknowledge.databinding.UserFragmentBinding

class UserValidator (private val binding: UserFragmentBinding){

    private var isPasswordValid: Boolean = false
    private var _isFromValid = MutableLiveData<Boolean>()
    val isFormValid: LiveData<Boolean>
        get() = _isFromValid

    init{
        isPasswordValid = !TextUtils.isEmpty(binding.passwordEdit.text.toString())
        evaluateFormValidation()
    }
    fun passwordValidator(editable: Editable){
        if(TextUtils.isEmpty(editable.toString())){
            binding.passwordEdit.error = "The password must not be empty"
            isPasswordValid = false
        }else{
            binding.passwordEdit.error = null
            isPasswordValid = true
        }
        evaluateFormValidation()
    }


     private fun evaluateFormValidation(){
        _isFromValid.value = isPasswordValid
    }
}