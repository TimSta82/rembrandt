package de.bornholdtlee.rembrandt.usecases

import de.bornholdtlee.rembrandt.repositories.FireBaseRepository
import org.koin.core.inject

class GetUserUseCase : BaseUseCase() {

    private val fireBaseRepository by inject<FireBaseRepository>()

    fun getUser() = fireBaseRepository.getUser()
}