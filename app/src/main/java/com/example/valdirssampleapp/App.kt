package com.example.valdirssampleapp

import android.app.Application
import com.example.valdirssampleapp.networking.ApiService

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        ApiService.init(this)
    }
}
