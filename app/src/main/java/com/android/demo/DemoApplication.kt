package com.android.demo

import android.app.Application
import com.android.core.di.coreModule
import com.android.core.network.networkModule
import com.android.feature_home.di.homeModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class DemoApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@DemoApplication)
            modules(listOf(coreModule, networkModule, homeModule))
        }
    }
}