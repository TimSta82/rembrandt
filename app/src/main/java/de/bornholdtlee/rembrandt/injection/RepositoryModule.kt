package de.bornholdtlee.rembrandt.injection

import de.bornholdtlee.rembrandt.repositories.FireBaseRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

var repositoryModule = module {

    single { FireBaseRepository(androidContext()) }
}