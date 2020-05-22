package com.example.completeandroidknowledge.section1.viewModel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.completeandroidknowledge.R
import com.example.completeandroidknowledge.databinding.ActivityPublicBinding

class PublicActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPublicBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_public)
    }
}
