package de.bornholdtlee.rembrandt.usecases

import de.bornholdtlee.rembrandt.repositories.FireBaseRepository
import org.koin.core.inject

class CheckForUserUseCase : BaseUseCase() {

    private val fireBaseRepository by inject<FireBaseRepository>()

    fun isLoggedIn() : Boolean {
        return fireBaseRepository.isLoggedIn()
    }
}