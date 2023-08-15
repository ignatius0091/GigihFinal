package com.tuse.afinal

import android.app.Application
import com.tuse.afinal.data.AppContainer
import com.tuse.afinal.data.DefaultAppContainer

class DisasterApplication: Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}