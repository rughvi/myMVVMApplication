package com.example.mymvvmdagger2application.di

import com.example.mymvvmdagger2application.LoginFragment
import com.example.mymvvmdagger2application.MainActivity
import dagger.Component

@Component(modules = [ViewModelModule::class])
interface ApplicationComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(loginFragment: LoginFragment)
}