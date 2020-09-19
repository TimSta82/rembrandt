package de.bornholdtlee.rembrandt.injection

import de.bornholdtlee.rembrandt.database.AppKeyValueStore
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

var dataModule = module {
    single { AppKeyValueStore(androidContext()) }
}