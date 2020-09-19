package de.bornholdtlee.rembrandt.ui.lobby

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import de.bornholdtlee.rembrandt.R
import de.bornholdtlee.rembrandt.models.Player
import kotlinx.android.synthetic.main.fragment_lobby.*

class LobbyFragment : Fragment(R.layout.fragment_lobby) {

    private val args by navArgs<LobbyFragmentArgs>()

    private val viewModel by viewModels<LobbyViewModel>()

    companion object {
        val TAG = LobbyFragment::class.java.name
        fun show(uid: String): LobbyFragment {
            val bundle = bundleOf("uid" to uid)
            return LobbyFragment().apply { bundle }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
    }

    private fun initViews() {
        viewModel.player.observe(viewLifecycleOwner, { setPlayer(it) })
    }

    private fun setPlayer(player: Player) {
        lobby_user_Tv.text = "name: ${player.name}, email: ${player.email}, uid: ${player.uid}"

    }
}