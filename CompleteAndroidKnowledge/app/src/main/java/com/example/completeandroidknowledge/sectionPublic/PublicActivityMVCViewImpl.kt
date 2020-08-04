package com.example.completeandroidknowledge.sectionPublic

import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import com.example.completeandroidknowledge.R
import com.example.completeandroidknowledge.commons.Constants
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
                R.id.item_home -> {updateOnFooterOptionClicked(Constants.Companion.FOOTER.HOME)}
                R.id.item_new_products -> {updateOnFooterOptionClicked(Constants.Companion.FOOTER.PRODUCTS_INFO)}
                R.id.item_new -> {updateOnFooterOptionClicked(Constants.Companion.FOOTER.NEWS)}
            }
            true
        }
    }

    private fun updateOnFooterOptionClicked(selected: Constants.Companion.FOOTER) {
        getListener().forEach {
            it.onFooterClicked(selected)
        }
    }
    override fun setLifecycleOwner(owner: LifecycleOwner) {
        binding.lifecycleOwner = owner
    }
}