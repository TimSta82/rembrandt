package de.bornholdtlee.rembrandt.ui.register

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import de.bornholdtlee.rembrandt.R
import kotlinx.android.synthetic.main.fragment_register.*

class RegisterFragment : Fragment(R.layout.fragment_register) {

    companion object {
        val TAG = RegisterFragment::class.java.name
    }

    private val viewModel: RegisterViewModel by lazy { ViewModelProviders.of(this).get(RegisterViewModel::class.java) }
    private lateinit var auth: FirebaseAuth


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        auth = FirebaseAuth.getInstance()
        initViews()
        initObservers()
        initListeners()
    }

    private fun initViews() {
    }

    private fun initListeners() {
        register_submit_user_Btn.setOnClickListener { registerUser() }
    }

    private fun registerUser() {
        val name = register_user_name_Et.text.toString().trim()
        val email = register_user_email_Et.text.toString().trim()
        val password = register_user_password_Et.text.toString().trim()
        val passwordRepeat = register_user_password_repeat_Et.text.toString().trim()

        if (name.isNotBlank() && email.isNotEmpty() && password.isNotEmpty() && passwordRepeat.isNotEmpty()) {
            if (password == passwordRepeat) {
                viewModel.registerUser(auth, name, email, password)
            } else {
                Toast.makeText(requireContext(), TAG + " password is invalid", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun initObservers() {
        viewModel.status.observe(viewLifecycleOwner, Observer { checkStatus(it) })
    }

    private fun checkStatus(status: Status) {
        when (status) {
            Status.LOADING -> Toast.makeText(requireContext(), "Loading", Toast.LENGTH_SHORT).show()
            Status.DONE -> findNavController().navigate(R.id.lobbyFragment)
            Status.ERROR -> Toast.makeText(requireContext(), "Error", Toast.LENGTH_SHORT).show()
        }
    }

}