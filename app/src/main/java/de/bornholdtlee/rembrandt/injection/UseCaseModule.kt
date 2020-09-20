package de.bornholdtlee.rembrandt.injection

import de.bornholdtlee.rembrandt.usecases.*
import org.koin.dsl.module

var useCaseModule = module {
    single { RegisterUserUseCase() }
    single { LoginUserUseCase() }
    single { GetUserUseCase() }
    single { LogoutUserUseCase() }
    single { CheckForUserUseCase() }
}