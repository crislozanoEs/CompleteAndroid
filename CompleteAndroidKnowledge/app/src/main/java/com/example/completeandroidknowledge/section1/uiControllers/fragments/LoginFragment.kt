package com.example.completeandroidknowledge.section1.uiControllers.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.example.completeandroidknowledge.R
import com.example.completeandroidknowledge.databinding.LoginFragmentBinding
import com.example.completeandroidknowledge.section1.viewModel.LoginViewModel
import timber.log.Timber

class LoginFragment : Fragment() {
    //private var user: User = User("Usuario", "", "")
    private lateinit var binding: LoginFragmentBinding
    private lateinit var viewModel: LoginViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.login_fragment, container, false)
        //binding.user = user
        viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        binding.loginViewModel = viewModel
        binding.lifecycleOwner = this
        binding.nextUserButton.setOnClickListener { v: View -> transferToUserPage(v) }
        return binding.root
    }

    fun transferToUserPage(v: View){
        this.viewModel.alterUser(binding.typeDocEdit.text.toString(), binding.textDocEdit.text.toString())
        val userType = viewModel.userType.value ?: ""
        val userDoc = viewModel.userDoc.value ?: ""
        Log.d("LoginFragment","User "+userDoc)
        v.findNavController ().navigate(LoginFragmentDirections.actionLoginFragmentToUserFragment(userType, userDoc))
        //v.findNavController ().navigate(LoginFragmentDirections.actionLoginFragmentToUserFragment(user.type, user.document))
    }
}
