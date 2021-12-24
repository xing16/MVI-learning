package com.xing.mvilearning.application

import android.app.Application
import com.xing.mvilearning.di.dataSourceModule
import com.xing.mvilearning.di.repositoryModule
import com.xing.mvilearning.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class PlayApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@PlayApplication)
            modules(dataSourceModule)
            modules(repositoryModule)
            modules(viewModelModule)
        }
    }
}