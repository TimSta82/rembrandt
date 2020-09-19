package de.bornholdtlee.rembrandt.ui.lobby

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import de.bornholdtlee.rembrandt.R
import de.bornholdtlee.rembrandt.models.Player

class LobbyActivity : AppCompatActivity() {

    companion object {
        val TAG = LobbyActivity::class.java.name
        fun startActivity(context: Context) {
            val lobbyIntent = Intent(context, LobbyActivity::class.java)
            context.startActivity(lobbyIntent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lobby)

        val navController = findNavController(R.id.nav_host_lobby_container)
        navController.navigate(R.id.lobbyFragment)
    }
}