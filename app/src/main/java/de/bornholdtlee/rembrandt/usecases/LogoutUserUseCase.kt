package de.bornholdtlee.rembrandt.usecases

import de.bornholdtlee.rembrandt.repositories.FireBaseRepository
import kotlinx.coroutines.launch
import org.koin.core.inject

class LogoutUserUseCase : BaseUseCase() {

    private val fireBaseRepository by inject<FireBaseRepository>()

    fun logout() {
        useCaseScope.launch {
            fireBaseRepository.logoutUser()
        }
    }
}