package com.example.completeandroidknowledge.sectionPublic.feature21News.uiControl

import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.example.completeandroidknowledge.commons.controllers.BaseFragmentPublic
import com.example.completeandroidknowledge.commons.navigation.NavigationActivity
import com.example.completeandroidknowledge.sectionPublic.feature21News.utilities.CameraFun
import com.example.completeandroidknowledge.sectionPublic.feature21News.utilities.CustomImageAnalyzer
import com.example.completeandroidknowledge.sectionPublic.feature21News.viewMVC.NewsFragmentMVCView
import com.example.completeandroidknowledge.sectionPublic.feature21News.viewModel.NewsViewModel
import com.example.completeandroidknowledge.sectionPublic.feature21News.viewModel.NewsViewModelFactory
import kotlinx.android.synthetic.main.new_fragment.*

class NewsFragmentPublic: BaseFragmentPublic(), NavigationActivity.Listener, NewsFragmentMVCView.Listener {

    companion object{
        private const val TAG = "CameraX"
        private const val REQUEST_CODE_PERMISSIONS = 1001
        private val REQUIRED_PERMISSION = arrayOf(android.Manifest.permission.CAMERA)
    }
    private lateinit var newsFragmentMVCView: NewsFragmentMVCView
    private lateinit var viewModel: NewsViewModel
    private lateinit var navigationActivity: NavigationActivity
    private lateinit var baseContext: Context
    private lateinit var cameraFun: CameraFun
    private lateinit var newsViewModelFactory: NewsViewModelFactory
    private lateinit var customImageAnalyzer: CustomImageAnalyzer
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        baseContext = context!!
        customImageAnalyzer = getCompositionRootObject().getCustomImageAnalyzer()
        newsFragmentMVCView = getCompositionRootObject().getViewMVCFactory().getNewsFragmentMVCView(container)
        newsFragmentMVCView.setLifecycleOwner(this)
        navigationActivity = getCompositionRootObject().getMainNavigation()
        newsViewModelFactory = NewsViewModelFactory(customImageAnalyzer)
        viewModel = ViewModelProvider(this, newsViewModelFactory).get(NewsViewModel::class.java)
        return newsFragmentMVCView.getRootView()
    }
    override fun onStart() {
        cameraFun = getCompositionRootObject().getCameraFun(viewFinder, this, customImageAnalyzer)
        if(allPermissionGranted()){
            cameraFun.startCamera()
        }else{
            ActivityCompat.requestPermissions(getCompositionRootObject().getActivity(), REQUIRED_PERMISSION, REQUEST_CODE_PERMISSIONS)
        }
        newsFragmentMVCView.registerListener(this)
        navigationActivity.registerListener(this)
        super.onStart()
    }

    override fun onStop() {
        newsFragmentMVCView.unregisterListener(this)
        navigationActivity.unregisterListener(this)
        super.onStop()
    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if(requestCode == REQUEST_CODE_PERMISSIONS){
            if(allPermissionGranted()){
                cameraFun.startCamera()
            }else{
                makeMessageNotPermissionGranted()
            }
        }
    }

    private fun makeMessageNotPermissionGranted() {
        TODO("Not yet implemented")
    }

    private fun allPermissionGranted() = REQUIRED_PERMISSION.all {
        ContextCompat.checkSelfPermission(baseContext, it) == PackageManager.PERMISSION_GRANTED
    }

    override fun onHomeClicked() {
        navigationActivity.fromNewsToHome()
    }

    override fun onProductsInfoClicked() {
        navigationActivity.fromNewsToProductsInfo()
    }

    override fun onNewsClicked() {
        //Not needed of moving
    }

    override fun onTakePhotoClicked() {
        Log.i("CameraX","onTakePhotoClicked")
        cameraFun.takePhoto()
    }
}