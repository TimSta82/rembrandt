package de.bornholdtlee.rembrandt.models

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class Player(
    var uid: String? = "",
    var name: String? = "",
    var email: String? = ""
)
