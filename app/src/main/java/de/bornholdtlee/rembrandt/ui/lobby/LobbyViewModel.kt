package de.bornholdtlee.rembrandt.ui.lobby

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import de.bornholdtlee.rembrandt.models.Player
import de.bornholdtlee.rembrandt.usecases.GetUserUseCase
import de.bornholdtlee.rembrandt.usecases.LogoutUserUseCase
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent
import org.koin.core.inject

class LobbyViewModel : ViewModel(), KoinComponent {

    private val getUserUseCase by inject<GetUserUseCase>()
    private val logoutUserUseCase by inject<LogoutUserUseCase>()
    private val _player = MutableLiveData<Player>()
    val player: LiveData<Player> = _player

    init {
        _player.value = getUserUseCase.getUser()
    }

    fun logoutUser() {
        viewModelScope.launch {
            logoutUserUseCase.logout()
        }
    }
}
