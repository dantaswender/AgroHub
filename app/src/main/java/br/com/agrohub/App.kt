package br.com.agrohub

import android.app.Application
import br.com.agrohub.di.appModule
import br.com.agrohub.di.climaModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.module.Module

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(
                listOf<Module>(
                    appModule,
                    climaModule
                )
            )
        }
    }
}