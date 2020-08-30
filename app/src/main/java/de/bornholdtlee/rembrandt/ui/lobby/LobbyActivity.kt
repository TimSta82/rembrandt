package de.bornholdtlee.rembrandt.ui.lobby

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import de.bornholdtlee.rembrandt.R

class LobbyActivity : AppCompatActivity() {

    companion object {
        val TAG = LobbyActivity::class.java.name
        val FIREBASE_USER_UID = "FIREBASE_USER_UID"
        fun startActivity(context: Context, uid: String) {
            val lobbyIntent = Intent(context, LobbyActivity::class.java).apply {
                putExtra(FIREBASE_USER_UID, uid)
            }
            context.startActivity(lobbyIntent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lobby)
        val uid: String? = intent.getStringExtra(FIREBASE_USER_UID)

//        findNavController(R.id.nav_host_lobby_container).navigate(R.id.action_registerFragment_to_lobbyFragment, bundle)
        uid?.let {
            supportFragmentManager.beginTransaction()
                .add(R.id.nav_host_lobby_container, LobbyFragment.show(it))
        }
    }
}