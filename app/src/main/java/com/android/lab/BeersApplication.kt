package com.android.lab

import android.app.Application
import com.android.lab.data.NetworkManager
import com.android.lab.data.dataModule
import com.android.lab.domain.domainModule
import com.android.lab.ui.uiModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class BeersApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        NetworkManager.start(this)
        startDependencyInjectionWithKoin()
    }

    private fun startDependencyInjectionWithKoin() {
        startKoin{
            androidLogger()
            androidContext(this@BeersApplication)
            modules(dataModule, domainModule, uiModule)
        }
    }
}