package com.example.completeandroidknowledge.sectionPublic.feature21News.utilities

import android.annotation.SuppressLint
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy
import com.example.completeandroidknowledge.commons.BaseObservable
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.label.ImageLabel
import com.google.mlkit.vision.label.ImageLabeling
import com.google.mlkit.vision.label.defaults.ImageLabelerOptions


class CustomImageAnalyzer: ImageAnalysis.Analyzer, BaseObservable<CustomImageAnalyzer.Listener>() {

    interface Listener{
        fun onAnalysisSucceed(list: List<ImageLabel>)
        fun onCameraError()
        fun onCaptureImageError()
        fun onAnalysisError()
    }
    @SuppressLint("UnsafeExperimentalUsageError")
    override fun analyze(imageProxy: ImageProxy) {
        val mediaImage = imageProxy.image
        if(mediaImage != null){
            val image = InputImage.fromMediaImage(mediaImage, imageProxy.imageInfo.rotationDegrees)
            val options = ImageLabelerOptions.Builder()
                .setConfidenceThreshold(0.7f)
                .build()
            val labeler = ImageLabeling.getClient(options)
            labeler.process(image).addOnSuccessListener {
                if(it != null){
                    getListeners().forEach{ listener ->
                        listener.onAnalysisSucceed(it)
                    }
                }else{
                    getListeners().forEach{ listener ->
                        listener.onAnalysisError()
                    }
                }
            }
        }
    }

    fun setOnErrorCamera() {
        getListeners().forEach {
            it.onCameraError()
        }
    }

    fun setOnErrorCaptureImage() {
        getListeners().forEach {
            it.onCaptureImageError()
        }
    }
}