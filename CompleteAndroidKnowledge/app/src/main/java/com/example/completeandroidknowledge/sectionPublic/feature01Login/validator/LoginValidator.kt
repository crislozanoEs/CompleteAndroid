package com.example.completeandroidknowledge.sectionPublic.feature01Login.validator

import android.text.Editable
import android.text.TextUtils
import android.widget.EditText
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
        _isFromValid.value = false
    }
    fun userValidator(editable: Editable){
        if(TextUtils.isEmpty(editable.toString())){
            binding.textDocEdit.error = "El usuario no debe estar vacio"
            isUserValid = false
        }else{
            binding.textDocEdit.error = null
            isUserValid = true
        }
        evaluateFormValidation()
    }

    fun typeUserValidator(editable: Editable){
        if(TextUtils.isEmpty(editable.toString())){
            binding.typeDocEdit.error = "El usuario no debe estar vacio"
            isTypeUserValid = false
        }else{
            binding.typeDocEdit.error = null
            isTypeUserValid = true
        }
        evaluateFormValidation()
    }

    private fun evaluateFormValidation(){
        _isFromValid.value = isUserValid && isTypeUserValid
    }
}