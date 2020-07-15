package com.example.completeandroidknowledge.sectionPublic.feature01Login.validator

import android.text.Editable
import android.text.TextUtils
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.completeandroidknowledge.databinding.LoginFragmentBinding

class LoginValidator (private val binding: LoginFragmentBinding){

    private var isUserValid: Boolean = false
    private var isTypeUserValid: Boolean = true
    private var _isFromValid = MutableLiveData<Boolean>()
    val isFormValid: LiveData<Boolean>
        get() = _isFromValid

    init{
        isUserValid = !TextUtils.isEmpty(binding.textDocEdit.text.toString())
        evaluateFormValidation()
    }
    fun userValidator(editable: Editable){
        if(TextUtils.isEmpty(editable.toString())){
            binding.textDocEdit.error = "The user must not be empty"
            isUserValid = false
        }else{
            binding.textDocEdit.error = null
            isUserValid = true
        }
        evaluateFormValidation()
    }

    fun typeUserValidator(editable: Editable){
        isTypeUserValid = !TextUtils.isEmpty(editable.toString())
        evaluateFormValidation()
    }

     private fun evaluateFormValidation(){
        _isFromValid.value = isUserValid && isTypeUserValid
    }
}