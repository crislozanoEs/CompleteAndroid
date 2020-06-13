package com.example.completeandroidknowledge.section1.uiControllers.fragments.packageMVCViews

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import com.example.completeandroidknowledge.R
import com.example.completeandroidknowledge.databinding.LoginFragmentBinding
import com.example.completeandroidknowledge.section1.viewModel.LoginViewModel

open class LoginFragmentMVCView(inflater: LayoutInflater, parent: ViewGroup?) {

    private var binding: LoginFragmentBinding =
        DataBindingUtil.inflate(inflater, R.layout.login_fragment, parent, false)

    interface Listener{
        fun onNextButtonClick()
    }
    init{
        binding.nextUserButton.setOnClickListener{ notifyListeners() }
    }

    private val listeners = mutableSetOf<Listener>()

    private fun notifyListeners(){
        listeners.forEach {
            it.onNextButtonClick()
        }
    }
    fun getRootView(): View = binding.root

    fun registerListener(listener: Listener) = listeners.add(listener)
    fun unregisterListener(listener: Listener) = listeners.remove(listener)

    fun setViewModel(viewModel: LoginViewModel){
        binding.loginViewModel = viewModel
    }
    fun setLifeCycleOwner(owner: LifecycleOwner){
        binding.lifecycleOwner = owner
    }

    fun getTypeDocument(): String = binding.typeDocEdit.text.toString()

    fun getDocument(): String = binding.textDocEdit.text.toString()

}