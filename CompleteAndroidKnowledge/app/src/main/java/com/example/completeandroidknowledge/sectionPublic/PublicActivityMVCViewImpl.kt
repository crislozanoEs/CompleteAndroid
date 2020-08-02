package com.example.completeandroidknowledge.sectionPublic

import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import com.example.completeandroidknowledge.R
import com.example.completeandroidknowledge.commons.views.ObservableViewMVCImpl
import com.example.completeandroidknowledge.databinding.ActivityPublicBinding

class PublicActivityMVCViewImpl(activity: PublicActivity): PublicActivityMVCView,
    ObservableViewMVCImpl<PublicActivityMVCView.Listener, ActivityPublicBinding>() {

    override var binding: ActivityPublicBinding = DataBindingUtil.setContentView(activity, R.layout.activity_public)

    init {
        bindNavigationListenerBottom()
    }
    private fun bindNavigationListenerBottom() {
        binding.bottomNavigation.setOnNavigationItemSelectedListener {item ->
            when(item.itemId){
                R.id.item_home -> {updateOnClickHome()}
                R.id.item_new_products -> {updateOnClickProductsInfo()}
                R.id.item_new -> {updateOnClickNews()}
            }
            true
        }
    }

    private fun updateOnClickHome(){
        getListener().forEach {
            it.onClickOnHome()
        }
    }

    private fun updateOnClickNews(){
        getListener().forEach {
            it.onClickInOnNews()
        }
    }

    private fun updateOnClickProductsInfo(){
        getListener().forEach {
            it.onClickOnProductsInfo()
        }
    }

    override fun setLifecycleOwner(owner: LifecycleOwner) {
        binding.lifecycleOwner = owner
    }
}