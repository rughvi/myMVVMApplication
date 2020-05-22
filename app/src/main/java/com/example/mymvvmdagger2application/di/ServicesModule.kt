package com.example.mymvvmdagger2application.di

import com.example.mymvvmdagger2application.services.LoginServiceInterface
import dagger.Module
import dagger.Provides

@Module
class ServicesModule {
    @Provides
    fun provideApiService(): LoginServiceInterface {
        return LoginServiceInterface.create()
    }
}