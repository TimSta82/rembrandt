package de.bornholdtlee.rembrandt.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import de.bornholdtlee.rembrandt.models.Player
import de.bornholdtlee.rembrandt.usecases.CheckForUserUseCase
import de.bornholdtlee.rembrandt.usecases.GetUserUseCase
import org.koin.core.KoinComponent
import org.koin.core.inject

class MainViewModel : ViewModel(), KoinComponent {

    private val checkForUserUseCase by inject<CheckForUserUseCase>()
    private val getUserUseCase by inject<GetUserUseCase>()

    private val _isLoggedIn = MutableLiveData<Boolean>()
    val isLoggedIn : LiveData<Boolean> = _isLoggedIn

    private val _player = MutableLiveData<Player>()
    val player: LiveData<Player> = _player

    init {
        isLoggedIn()
    }

    private fun isLoggedIn() {
        _isLoggedIn.value = checkForUserUseCase.isLoggedIn()
    }

    fun getUser() {
        _player.value = getUserUseCase.getUser()
    }
}
