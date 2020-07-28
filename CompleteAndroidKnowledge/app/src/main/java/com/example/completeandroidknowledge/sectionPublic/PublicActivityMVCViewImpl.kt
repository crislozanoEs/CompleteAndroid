package com.example.completeandroidknowledge.sectionPublic

import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import com.example.completeandroidknowledge.R
import com.example.completeandroidknowledge.commons.views.ObservableViewMVCImpl
import com.example.completeandroidknowledge.databinding.ActivityPublicBinding

class PublicActivityMVCViewImpl(activity: PublicActivity): PublicActivityMVCView,
    ObservableViewMVCImpl<PublicActivityMVCView.Listener, ActivityPublicBinding>() {

    override var binding: ActivityPublicBinding = DataBindingUtil.setContentView(activity, R.layout.activity_public)

    override fun setLifeCycleOwnerView(owner: LifecycleOwner) {
        binding.lifecycleOwner = owner
    }
    init {
        bindNavigationListenerBottom()
    }
    private fun bindNavigationListenerBottom() {
        binding.bottomNavigation.setOnNavigationItemSelectedListener {item ->
            when(item.itemId){
                R.id.item_home -> {
                    if(binding.bottomNavigation.selectedItemId != R.id.item_home){
                        when(binding.bottomNavigation.selectedItemId){
                            R.id.item_new_products -> {updateGoFromProductsInfoToLogin()}
                        }
                    }
                }
                R.id.item_new_products -> {
                    if(binding.bottomNavigation.selectedItemId != R.id.item_new_products){
                        when(binding.bottomNavigation.selectedItemId){
                            R.id.item_home -> {updateGoFromLoginToProductsInfo()}
                        }
                    }
                }
            }
            true
        }
    }

    private fun updateGoFromProductsInfoToLogin(){
        getListener().forEach {
            it.goFromProductsInfoToLoginFragment()
        }
    }

    private fun updateGoFromLoginToProductsInfo(){
        getListener().forEach {
            it.goFromLoginFragmentToProductsInfo()
        }
    }
}