package com.example.define

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class DefineApplication : Application() {

    override fun onCreate() {
        super.onCreate()
    }

}