package com.example.completeandroidknowledge.sectionPublic.feature01Login.viewMVC

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import com.example.completeandroidknowledge.R
import com.example.completeandroidknowledge.commons.views.ObservableViewMVCImpl
import com.example.completeandroidknowledge.databinding.LoginFragmentBinding
import com.example.completeandroidknowledge.sectionPublic.feature01Login.validator.LoginValidator
import com.example.completeandroidknowledge.sectionPublic.feature01Login.viewModel.LoginViewModel

class LoginFragmentMVCViewImpl(inflater: LayoutInflater, parent: ViewGroup?) :
    LoginFragmentMVCView, ObservableViewMVCImpl<LoginFragmentMVCView.Listener, LoginFragmentBinding>() {

    override var binding: LoginFragmentBinding =
        DataBindingUtil.inflate(inflater, R.layout.login_fragment, parent, false)

    private lateinit var loginValidator: LoginValidator

    init{
        binding.nextUserButton.setOnClickListener{ notifyListeners() }
        setRootView(binding.root)
    }

    private fun notifyListeners(){
        getListener().forEach {
            it.onNextButtonClick()
        }
    }
    override fun getRootView(): View = binding.root

    override fun setViewModel(viewModel: LoginViewModel){
        binding.loginViewModel = viewModel
    }
    override fun getTypeDocument(): String = binding.typeDocEdit.selectedItem.toString()

    override fun getDocument(): String = binding.textDocEdit.text.toString()

    override fun initDocumentsSpinner(documents: List<String>, context: Context) {
        val adapter = ArrayAdapter(context, android.R.layout.simple_spinner_dropdown_item, documents)
        binding.typeDocEdit.adapter = adapter
    }

    override fun startValidator() {
        loginValidator = LoginValidator(binding)
        binding.validator = loginValidator
    }

    override fun setLifecycleOwner(owner: LifecycleOwner) {
        binding.lifecycleOwner = owner
    }

}