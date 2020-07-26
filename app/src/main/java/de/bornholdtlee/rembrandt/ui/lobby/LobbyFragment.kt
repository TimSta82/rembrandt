package de.bornholdtlee.rembrandt.ui.lobby

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import de.bornholdtlee.rembrandt.R

class LobbyFragment : Fragment(R.layout.fragment_lobby) {

    private lateinit var auth: FirebaseAuth
    companion object {
        val TAG = LobbyFragment::class.java.name
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        auth = FirebaseAuth.getInstance()

        Toast.makeText(requireContext(), TAG + " user: " + auth.currentUser, Toast.LENGTH_SHORT).show()

    }
}