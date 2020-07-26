package de.bornholdtlee.rembrandt.ui.lobby

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class LobbyActivity : AppCompatActivity() {

    companion object {
        val TAG = LobbyActivity::class.java.name
        fun startActivity(context: Context) {
            context.startActivity(Intent(context, LobbyActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}