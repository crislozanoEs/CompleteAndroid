package com.example.completeandroidknowledge.sectionPublic.feature21News.utilities

import android.content.Context
import android.util.Log
import androidx.camera.core.*
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.core.content.ContextCompat
import androidx.lifecycle.LifecycleOwner

class CameraFun(private var context: Context,
                private var viewFinder: PreviewView,
                private var lifecycleOwner: LifecycleOwner,
                private var customImageAnalyzer: CustomImageAnalyzer) {

    private lateinit var imageCapture: ImageCapture

    fun startCamera(){
        val cameraProvider = ProcessCameraProvider.getInstance(context)
        cameraProvider.addListener(Runnable {
            val cameraProviderImpl: ProcessCameraProvider = cameraProvider.get()
            val preview = Preview.Builder().build().also{
                it.setSurfaceProvider(viewFinder.createSurfaceProvider())
            }
            imageCapture = ImageCapture.Builder().build()
            val cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA
            try{
                cameraProviderImpl.unbindAll()
                cameraProviderImpl.bindToLifecycle(lifecycleOwner, cameraSelector, preview, imageCapture)
            }catch (e: Exception){
                customImageAnalyzer.setOnErrorCamera()
                Log.e("CameraX","Error creating preview ${e}")
            }
        }, ContextCompat.getMainExecutor(context))
    }

    fun takePhoto(){
        val imageCapture = imageCapture ?: return
        imageCapture.takePicture(ContextCompat.getMainExecutor(context), object :
            ImageCapture.OnImageCapturedCallback() {
            override fun onCaptureSuccess(image: ImageProxy) {
                Log.i("CameraX", "Photo captured")
                customImageAnalyzer.analyze(image)
            }
            override fun onError(exc: ImageCaptureException) {
                customImageAnalyzer.setOnErrorCaptureImage()
                Log.e("CameraX", "Photo error "+exc.toString())
            }
        })
    }

}