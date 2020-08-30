package de.bornholdtlee.rembrandt.ui.lobby

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.firebase.auth.FirebaseAuth
import de.bornholdtlee.rembrandt.R

class LobbyFragment : Fragment(R.layout.fragment_lobby) {

    private lateinit var auth: FirebaseAuth
    companion object {
        val TAG = LobbyFragment::class.java.name
        fun show(uid: String) : LobbyFragment {
            val bundle = bundleOf("uid" to uid)
            return  LobbyFragment().apply { bundle }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val uid : String = arguments?.get("uid").toString()



//        auth = FirebaseAuth.getInstance()

        Toast.makeText(requireContext(), TAG + " userUid: " + uid, Toast.LENGTH_SHORT).show()

    }
}