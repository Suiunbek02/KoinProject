package com.example.koinproject

import android.app.Application
import com.example.koinproject.servicelocator.appModule
import com.example.koinproject.servicelocator.dataModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        GlobalContext.startKoin {
            androidContext(this@App)
            modules(appModule, dataModule)
        }
    }
}