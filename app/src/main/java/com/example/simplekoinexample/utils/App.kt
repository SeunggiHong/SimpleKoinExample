package com.example.simplekoinexample.utils

import android.app.Application
import com.example.simplekoinexample.appModule
import com.example.simplekoinexample.di.networkModule
import com.example.simplekoinexample.todoAppModule
import com.example.simplekoinexample.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    appModule,
                    todoAppModule,
                    networkModule,
                    viewModelModule
                )
            )
        }

    }

}