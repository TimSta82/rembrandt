package de.bornholdtlee.rembrandt.injection

import de.bornholdtlee.rembrandt.usecases.GetUserUseCase
import de.bornholdtlee.rembrandt.usecases.LoginUserUseCase
import de.bornholdtlee.rembrandt.usecases.RegisterUserUseCase
import org.koin.dsl.module

var useCaseModule = module {
    single { RegisterUserUseCase() }
    single { LoginUserUseCase() }
    single { GetUserUseCase() }
}