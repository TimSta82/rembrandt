package de.bornholdtlee.rembrandt.usecases

import de.bornholdtlee.rembrandt.repositories.FireBaseRepository
import kotlinx.coroutines.launch
import org.koin.core.inject

class RegisterUserUseCase : BaseUseCase() {

    private val fireBaseRepository by inject<FireBaseRepository>()

    fun registerUser(email: String, password: String) {
        useCaseScope.launch {
            fireBaseRepository.registerUser(email, password)
        }
    }
}