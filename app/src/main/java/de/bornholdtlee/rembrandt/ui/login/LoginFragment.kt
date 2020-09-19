package de.bornholdtlee.rembrandt.ui.login

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import de.bornholdtlee.rembrandt.R
import de.bornholdtlee.rembrandt.ui.lobby.LobbyActivity
import de.bornholdtlee.rembrandt.ui.register.Status
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment(R.layout.fragment_login) {

    companion object {
        val TAG = LoginFragment::class.java.name
    }

    private val viewModel: LoginViewModel by lazy {
        ViewModelProviders.of(this).get(LoginViewModel::class.java)
    }
    private lateinit var auth: FirebaseAuth

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        auth = FirebaseAuth.getInstance()
        initViews()
        initObservers()
        initListeners()
    }

    private fun initViews() {
        login_loading_Pb.visibility = View.GONE
    }

    private fun initListeners() {
        login_submit_user_Btn.setOnClickListener { loginUser() }
        login_forgot_password_Tv.setOnClickListener { forgotPassword() }
        login_register_Tv.setOnClickListener { findNavController().navigate(R.id.registerFragment) }
    }

    private fun forgotPassword() {
        Toast.makeText(requireContext(), TAG + "forgot password", Toast.LENGTH_SHORT).show()
    }

    private fun loginUser() {
        val email = login_user_email_Et.text.toString().trim()
        val password = login_user_password_Et.text.toString().trim()

        if (email.isNotEmpty() && password.isNotEmpty()) {
            viewModel.loginUser(email, password)
        } else {
            Toast.makeText(requireContext(), TAG + " password is invalid", Toast.LENGTH_SHORT)
                .show()
        }
    }

    private fun initObservers() {
        viewModel.status.observe(viewLifecycleOwner, { checkStatus(it) })
    }

    private fun checkStatus(status: Status) {
        when (status) {
            Status.LOADING -> {
                login_loading_Pb.visibility = View.VISIBLE
                Toast.makeText(requireContext(), "Loading", Toast.LENGTH_SHORT).show()
            }
            Status.DONE -> {
                login_loading_Pb.visibility = View.GONE
                LobbyActivity.startActivity(requireContext())
            }
            Status.ERROR -> {
                login_loading_Pb.visibility = View.GONE
                Toast.makeText(requireContext(), "Error", Toast.LENGTH_SHORT).show()
            }
        }
    }
}