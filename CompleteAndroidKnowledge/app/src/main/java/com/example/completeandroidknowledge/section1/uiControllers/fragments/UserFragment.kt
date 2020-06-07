package com.example.completeandroidknowledge.section1.uiControllers.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.completeandroidknowledge.R
import com.example.completeandroidknowledge.databinding.UserFragmentBinding
import com.example.completeandroidknowledge.section1.model.UserDatabase
import com.example.completeandroidknowledge.section1.viewModel.UserViewModel
import com.example.completeandroidknowledge.section1.viewModel.UserViewModelFactory
import com.example.completeandroidknowledge.section2.uiControllers.MainActivity

/**
 * A simple [Fragment] subclass.
 */
class UserFragment : Fragment() {

    private lateinit var binding: UserFragmentBinding
    private lateinit var viewModel: UserViewModel
    private lateinit var viewModelFactory: UserViewModelFactory
    // private var user: User = User("Usuario","", "")
    private lateinit var args: UserFragmentArgs
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.user_fragment, container,false)
        //binding.user = user
        args = UserFragmentArgs.fromBundle(arguments!!)
        val application = requireNotNull(this.activity).application
        val dataSource = UserDatabase.getInstance(application).userDatabaseDao
        viewModelFactory = UserViewModelFactory(args.documentType, args.document, dataSource)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(UserViewModel::class.java)
        binding.userViewModel = viewModel
        viewModel.navigationToMainFlag.observe(viewLifecycleOwner, Observer {hasFinished ->
            if(hasFinished){
                val intent = Intent(application.baseContext, MainActivity::class.java)
                startActivity(intent)
                viewModel.doneNavigation()
            }

        })
        binding.loginButton.setOnClickListener{_ -> transferToMainActivity()}
        // viewModel.user.observe(viewLifecycleOwner, Observer { user -> binding.userText.text = user.document })
        // user.document = args.document
        return binding.root
    }

    private fun transferToMainActivity(){
        viewModel.user.value!!.password = binding.passwordEdit.text.toString()
        viewModel.updatePasswordUser()
    }

}
