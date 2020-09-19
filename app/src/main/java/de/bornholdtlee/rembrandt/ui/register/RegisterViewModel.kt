package de.bornholdtlee.rembrandt.ui.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import de.bornholdtlee.rembrandt.models.Player
import de.bornholdtlee.rembrandt.usecases.RegisterUserUseCase
import org.koin.core.KoinComponent
import org.koin.core.inject

enum class Status {
    LOADING, DONE, ERROR
}

class RegisterViewModel : ViewModel(), KoinComponent {

    private val registerUserUseCase by inject<RegisterUserUseCase>()

    private val _status = MutableLiveData<Status>()
    val status: LiveData<Status> = _status

    fun registerUser(email: String, password: String) {
        _status.value = Status.LOADING
        registerUserUseCase.registerUser(email, password)
        _status.value = Status.DONE
    }
}
