package de.bornholdtlee.rembrandt.ui.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import de.bornholdtlee.rembrandt.models.Player

enum class Status {
    LOADING, DONE, ERROR
}

class RegisterViewModel: ViewModel() {

    private var database: DatabaseReference = Firebase.database.reference
    private var auth: FirebaseAuth = FirebaseAuth.getInstance()

    private val _status = MutableLiveData<Status>()

    val status: LiveData<Status> = _status

    fun registerUser(email: String, password: String) {
        _status.value = Status.LOADING
        try {
            auth.createUserWithEmailAndPassword(email, password)
            savePlayerInDatabase(email, auth.currentUser?.uid)
        } catch (e: Exception) {
            e.printStackTrace()
            _status.value = Status.ERROR
        }
    }

    private fun savePlayerInDatabase(email: String, uid: String?) {
        val player = Player(uid, "Egon", email)
        uid?.let { database.child("players").child(it).setValue(player) }
        _status.value = Status.DONE
    }
}

//private fun writeNewUser(userId: String, name: String, email: String?) {
//    val user = User(name, email)
//    database.child("users").child(userId).setValue(user)
//}