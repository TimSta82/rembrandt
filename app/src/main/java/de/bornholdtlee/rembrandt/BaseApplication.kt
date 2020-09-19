package de.bornholdtlee.rembrandt

import android.app.Application
import de.bornholdtlee.rembrandt.injection.dataModule
import de.bornholdtlee.rembrandt.injection.networkModule
import de.bornholdtlee.rembrandt.injection.repositoryModule
import de.bornholdtlee.rembrandt.injection.useCaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@BaseApplication)
            modules(networkModule + repositoryModule + dataModule + useCaseModule)
        }
    }
}