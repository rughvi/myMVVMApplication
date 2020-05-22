package com.example.mymvvmdagger2application.viewmodels

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mymvvmdagger2application.models.LoginRequest
import com.example.mymvvmdagger2application.repositories.TestRepository
import com.example.mymvvmdagger2application.services.LoginServiceInterface
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class LoginViewModel @Inject constructor(private var testRepository: TestRepository, private var loginServiceInterface: LoginServiceInterface) : ViewModel() {
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
        loginServiceInterface.login(LoginRequest(loginViewModel.username.toString(), loginViewModel.password.toString()))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({

            },
            {

            })
        println("${loginViewModel.username.value} = ${loginViewModel.password.value}")
    }
}
