package com.example.completeandroidknowledge.section1.uiControllers.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.example.completeandroidknowledge.R
import com.example.completeandroidknowledge.databinding.FragmentLoginBinding
import com.example.completeandroidknowledge.section1.model.User
import com.example.completeandroidknowledge.section1.viewModel.LoginViewModel

class LoginFragment : Fragment() {
    private var user: User = User("Usuario","", "")
    private lateinit var binding: FragmentLoginBinding
    private lateinit var viewModel: LoginViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_login, container, false)
        binding.user = user
        binding.nextUserButton.setOnClickListener { v: View-> v.findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToUserFragment(user.type, user.document)) }
        viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        return binding.root;
    }
}
