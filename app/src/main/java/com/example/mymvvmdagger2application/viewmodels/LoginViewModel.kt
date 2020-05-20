package com.example.mymvvmdagger2application.viewmodels

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mymvvmdagger2application.repositories.TestRepository
import javax.inject.Inject

class LoginViewModel @Inject constructor(private var testRepository: TestRepository) : ViewModel() {
    var username: MutableLiveData<String> = MutableLiveData<String>()
    var usernameError: MutableLiveData<String> = MutableLiveData<String>()
    var password: MutableLiveData<String> = MutableLiveData<String>()
    var passwordError: MutableLiveData<String> = MutableLiveData<String>()

    init {
        username.value = testRepository.getUsername()
        password.value = testRepository.getPassword()
    }

    fun Login(loginViewModel: LoginViewModel){
        if((loginViewModel?.username?.value?.length?:0) == 0){
            loginViewModel.usernameError.value = "Username is not valid"
            return
        }

        if((loginViewModel?.password?.value?.length?:0) == 0){
            loginViewModel.passwordError.value = "Password is not valid"
            return
        }

        println("${loginViewModel.username.value} = ${loginViewModel.password.value}")
    }
}
