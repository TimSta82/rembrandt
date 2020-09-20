package de.bornholdtlee.rembrandt.repositories

import android.content.Context
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import de.bornholdtlee.rembrandt.models.Player

class FireBaseRepository(val context: Context) : BaseRepository() {

    private var database: DatabaseReference = Firebase.database.reference
    private var auth: FirebaseAuth = FirebaseAuth.getInstance()
    private val firebaseUser = auth.currentUser

    fun isLoggedIn(): Boolean {
        return firebaseUser != null
    }

    fun registerUser(email: String, password: String) {
        try {
            auth.createUserWithEmailAndPassword(email, password)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun loginUser(email: String, password: String) {
        try {
            auth.signInWithEmailAndPassword(email, password)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun logoutUser() {
        try {
            auth.signOut()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun getUser(): Player {
        val player = Player("", "", "")
        try {
//            auth.addAuthStateListener {a ->
//                when (a) {
//
//                }
//
//            }
            val user = auth.currentUser
            user?.let {
                player.email = user.email
                player.uid = user.uid
                player.name = "norberto"
            }
            return player
        } catch (e: Exception) {
            e.printStackTrace()
            return player
        }
    }

    suspend fun saveInRealTimeDataBase() {
        val player = Player("uid123Abd", "TestName", "x@y.test")
        database.child("players").child("uid").setValue("hugo")
    }


}