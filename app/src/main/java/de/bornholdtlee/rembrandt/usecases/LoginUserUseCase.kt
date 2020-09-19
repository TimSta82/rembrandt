package de.bornholdtlee.rembrandt.usecases

import de.bornholdtlee.rembrandt.repositories.FireBaseRepository
import kotlinx.coroutines.launch
import org.koin.core.inject

class LoginUserUseCase : BaseUseCase() {

    private val fireBaseRepository by inject<FireBaseRepository>()

    fun loginUser(email: String, password: String) {
        useCaseScope.launch { fireBaseRepository.loginUser(email, password) }
    }
}