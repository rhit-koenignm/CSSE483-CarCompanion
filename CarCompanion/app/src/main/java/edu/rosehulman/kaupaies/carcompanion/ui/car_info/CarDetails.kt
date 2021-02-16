package edu.rosehulman.kaupaies.carcompanion.ui.car_info

import com.google.firebase.firestore.DocumentSnapshot
import edu.rosehulman.kaupaies.carcompanion.ui.troubleshooting.TroubleData

data class CarDetails
    (var nickname: String = "",
     var year: Int = 0,
     var make: String = "",
     var model: String = "",
     var VIN: String = "",
     var licenseState: String = "",
     var licensePlate: String = "",
//     var diagnosisList: ArrayList<TroubleData> = ArrayList<TroubleData>()
    ) {

    companion object {
        fun fromSnapshot(snapshot: DocumentSnapshot) : CarDetails {
            return snapshot.toObject(CarDetails::class.java)!!
        }
    }
}
