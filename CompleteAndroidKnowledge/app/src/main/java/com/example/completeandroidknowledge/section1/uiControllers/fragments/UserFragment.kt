package com.example.completeandroidknowledge.section1.uiControllers.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.completeandroidknowledge.R
import com.example.completeandroidknowledge.databinding.FragmentUserBinding
import com.example.completeandroidknowledge.section1.model.User
import timber.log.Timber

/**
 * A simple [Fragment] subclass.
 */
class UserFragment : Fragment() {

    private lateinit var binding: FragmentUserBinding
    private var user: User = User("Usuario","", "")
    private lateinit var args: UserFragmentArgs
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_user, container,false)
        binding.user = user
        args = UserFragmentArgs.fromBundle(arguments!!)
        user.document = args.document
        return binding.root
    }

}
