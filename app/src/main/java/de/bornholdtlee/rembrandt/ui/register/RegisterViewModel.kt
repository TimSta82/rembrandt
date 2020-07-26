package de.bornholdtlee.rembrandt.ui.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

enum class Status {
    LOADING, DONE, ERROR
}

class RegisterViewModel: ViewModel() {

    private val _status = MutableLiveData<Status>().apply { value = Status.LOADING }

    val status: LiveData<Status> = _status

    fun registerUser(auth: FirebaseAuth, name: String, email: String, password: String) {
        _status.value = Status.LOADING

        try {
            auth.createUserWithEmailAndPassword(email, password)
            _status.value = Status.DONE
        } catch (e: Exception) {
            e.printStackTrace()
            _status.value = Status.ERROR
        }
    }
}