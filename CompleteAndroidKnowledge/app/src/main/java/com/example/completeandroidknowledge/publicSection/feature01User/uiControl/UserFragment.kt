package com.example.completeandroidknowledge.publicSection.feature01User.uiControl

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.completeandroidknowledge.commons.controllers.BaseFragment
import com.example.completeandroidknowledge.commons.navigation.Navigation
import com.example.completeandroidknowledge.publicSection.PublicActivity
import com.example.completeandroidknowledge.publicSection.uiControllers.fragments.UserFragmentArgs
import com.example.completeandroidknowledge.publicSection.feature01User.viewMVC.UserFragmentMVCView
import com.example.completeandroidknowledge.publicSection.feature01User.viewModel.UserViewModel
import com.example.completeandroidknowledge.publicSection.feature01User.viewModel.UserViewModelFactory
import com.example.completeandroidknowledge.transtationalSection.uiControllers.MainActivity

/**
 * A simple [Fragment] subclass.
 */
class UserFragment : BaseFragment(), UserFragmentMVCView.Listener {

    private lateinit var userFragmentMVCView: UserFragmentMVCView
    private lateinit var viewModel: UserViewModel
    private lateinit var viewModelFactory: UserViewModelFactory
    private lateinit var args: UserFragmentArgs
    private lateinit var navigation: Navigation

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        userFragmentMVCView = getCompositionRootObject().getViewMVCFactory().getUserFragmentMVCView(container, getCompositionRootObject().getActivity() as PublicActivity)
        navigation = getCompositionRootObject().getNavigation()
        args =
            UserFragmentArgs.fromBundle(
                arguments!!
            )
        val application = requireNotNull(this.activity).application
        viewModelFactory =
            UserViewModelFactory(
                args.documentType,
                args.document,
                getCompositionRootObject().getUserDatabaseUseCase(application),
                getCompositionRootObject().getLoginServicesUseCase(),
                getCompositionRootObject().getDialogManager(),
                getCompositionRootObject().getDialogEventBus()
            )
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(UserViewModel::class.java)
        userFragmentMVCView.setViewModel(viewModel)
        userFragmentMVCView.setLifeCycleOwnerView(this)
        viewModel.navigationToMainFlag.observe(viewLifecycleOwner, Observer {hasFinished ->
            if(hasFinished){
                val intent = Intent(getCompositionRootObject().getContext(), MainActivity::class.java)
                startActivity(intent)
                viewModel.doneNavigation()
            }

        })
        viewModel.clearPasswordFlag.observe(viewLifecycleOwner, Observer {hasBeenCleaned ->
            if(hasBeenCleaned){
                userFragmentMVCView.clearPassword()
                viewModel.doneClearingPassword()
            }

        })
        viewModel.actualState.observe(viewLifecycleOwner, Observer {status ->
            val showLoading = when(status){
                UserViewModel.STATES.LOADING -> true
                UserViewModel.STATES.LOGIN_FAIL -> false
                UserViewModel.STATES.LOGIN_SUCCEED -> false
                else -> false
            }
            userFragmentMVCView.setLoadingVisibility(showLoading)
        })

        return userFragmentMVCView.getRootView()
    }

    override fun onStart() {
        super.onStart()
        userFragmentMVCView.registerListener(this)
    }

    override fun onStop() {
        super.onStop()
        userFragmentMVCView.unregisterListener(this)
    }

    override fun transferToMainActivity(){
        viewModel.user.value!!.password = userFragmentMVCView.getPassword()
        viewModel.executeLoginService()
    }
}
