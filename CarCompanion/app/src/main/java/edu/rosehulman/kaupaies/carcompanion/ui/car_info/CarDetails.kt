package edu.rosehulman.kaupaies.carcompanion.ui.car_info

import com.google.firebase.firestore.DocumentSnapshot

data class CarDetails (var nickname: String = "", var year: Int = 0, var make: String = "", var model: String = "") {
    companion object {
        fun fromSnapshot(snapshot: DocumentSnapshot) : CarDetails {
            val detail = snapshot.toObject(CarDetails::class.java)!!
            return detail
        }
    }
}
