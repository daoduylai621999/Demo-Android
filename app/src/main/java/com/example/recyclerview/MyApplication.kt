package com.example.recyclerview

import android.app.Application
import com.example.recyclerview.module.appModule
import com.example.recyclerview.module.dataModule
import com.example.recyclerview.module.repositoryModule
import com.example.recyclerview.module.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            modules(appModule, viewModelModule, repositoryModule, dataModule)
        }
    }
}