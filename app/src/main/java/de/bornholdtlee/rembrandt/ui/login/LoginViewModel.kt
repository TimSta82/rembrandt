package de.bornholdtlee.rembrandt.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import de.bornholdtlee.rembrandt.models.Player
import de.bornholdtlee.rembrandt.ui.register.Status
import de.bornholdtlee.rembrandt.usecases.GetUserUseCase
import de.bornholdtlee.rembrandt.usecases.LoginUserUseCase
import org.koin.core.KoinComponent
import org.koin.core.inject

class LoginViewModel : ViewModel(), KoinComponent {

    private val loginUserUseCase by inject<LoginUserUseCase>()

    private val _status = MutableLiveData<Status>()
    val status: LiveData<Status> = _status

    fun loginUser(email: String, password: String) {
        _status.value = Status.LOADING
        loginUserUseCase.loginUser(email, password)
        _status.value = Status.DONE
    }
}