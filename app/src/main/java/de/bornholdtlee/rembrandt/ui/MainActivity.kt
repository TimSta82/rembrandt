package de.bornholdtlee.rembrandt.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import de.bornholdtlee.rembrandt.R
import de.bornholdtlee.rembrandt.models.Player
import de.bornholdtlee.rembrandt.ui.lobby.LobbyActivity
import de.bornholdtlee.rembrandt.utils.Logger

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        setupNavigation()
        initObservers()
    }

    private fun initObservers() {
        viewModel.isLoggedIn.observe(this, { setLoginState(it) })
        viewModel.player.observe(this, { setUserName(it) })
    }

    private fun setUserName(player: Player) {
        player.email?.let { Logger.debug(it) }
    }

    private fun setLoginState(isLoggedIn: Boolean) {
        if (isLoggedIn) {
            viewModel.getUser()
            LobbyActivity.startActivity(this)
        } else {
            findNavController(R.id.nav_host_fragment_container)
        }
        Logger.debug("user logged in: $isLoggedIn")
    }

//    private fun setupNavigation() {
//    }
}