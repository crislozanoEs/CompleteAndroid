package com.example.completeandroidknowledge.section1.viewModel

import androidx.lifecycle.ViewModel
import com.example.completeandroidknowledge.section1.model.User

class LoginViewModel: ViewModel() {

    private var user: User = User("Usuario", "", "")
    
}