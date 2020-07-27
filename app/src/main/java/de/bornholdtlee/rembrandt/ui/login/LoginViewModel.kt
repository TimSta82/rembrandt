package de.bornholdtlee.rembrandt.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import de.bornholdtlee.rembrandt.ui.register.Status

class LoginViewModel: ViewModel() {

    private val _status = MutableLiveData<Status>()

    val status: LiveData<Status> = _status

    fun loginUser(auth: FirebaseAuth, email: String, password: String) {
        _status.value = Status.LOADING
        try {
            auth.signInWithEmailAndPassword(email, password)
            _status.value = Status.DONE
        } catch (e: Exception) {
            e.printStackTrace()
            _status.value = Status.ERROR
        }
    }
}