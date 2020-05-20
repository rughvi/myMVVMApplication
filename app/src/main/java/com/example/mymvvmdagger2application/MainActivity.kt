package com.example.mymvvmdagger2application

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mymvvmdagger2application.di.ApplicationComponent
import com.example.mymvvmdagger2application.di.DaggerApplicationComponent
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frameLayout, LoginFragment())
        transaction.commit()
    }
}
