package com.example.completeandroidknowledge.section1.uiControllers.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.completeandroidknowledge.R
import com.example.completeandroidknowledge.databinding.UserFragmentBinding
import com.example.completeandroidknowledge.section1.viewModel.UserViewModel
import com.example.completeandroidknowledge.section1.viewModel.UserViewModelFactory

/**
 * A simple [Fragment] subclass.
 */
class UserFragment : Fragment() {

    private lateinit var binding: UserFragmentBinding
    private lateinit var viewModel: UserViewModel
    private lateinit var viewModelFactory: UserViewModelFactory
    //private var user: User = User("Usuario","", "")
    private lateinit var args: UserFragmentArgs
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.user_fragment, container,false)
        //binding.user = user
        args = UserFragmentArgs.fromBundle(arguments!!)
        viewModelFactory = UserViewModelFactory(args.documentType, args.document)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(UserViewModel::class.java)
        binding.userViewModel = viewModel
        //viewModel.user.observe(viewLifecycleOwner, Observer { user -> binding.userText.text = user.document })
        //user.document = args.document
        return binding.root
    }

}
