package com.example.mymvvmdagger2application.repositories

import javax.inject.Inject

class TestRepository @Inject constructor() {
    fun getValue(): Int {
        return 999
    }

    fun getUsername(): String {
        return "user1"
    }

    fun getPassword(): String {
        return "pass1"
    }
}