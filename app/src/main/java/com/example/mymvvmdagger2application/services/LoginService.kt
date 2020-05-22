package com.example.mymvvmdagger2application.services

import com.example.mymvvmdagger2application.models.LoginRequest
import com.example.mymvvmdagger2application.models.LoginResponse
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginServiceInterface {
    @POST("login")
    fun login(@Body loginRequest: LoginRequest ): Observable<LoginResponse>

    companion object Factory{
        fun create(): LoginServiceInterface{
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://us-central1-mymvvmapplication-28077.cloudfunctions.net/")
                .build()

            return retrofit.create(LoginServiceInterface::class.java)
        }
    }
}