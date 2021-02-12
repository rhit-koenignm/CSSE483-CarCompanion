package edu.rosehulman.kaupaies.carcompanion.ui.car_info

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.QuerySnapshot
import edu.rosehulman.kaupaies.carcompanion.Constants
import edu.rosehulman.kaupaies.carcompanion.R

class CarDetailAdapter (var context: Context?): RecyclerView.Adapter<CarDetailViewHolder>() {

    private var carList:ArrayList<CarDetails> = ArrayList<CarDetails>()

    private val detailRef = FirebaseFirestore
        .getInstance()
        //TODO: If i uncomment the following line, it just absolutely floods the car detail collection
        // with something i placed as an initial entry to the collection; i have no idea why
//        .collection("cars")

    init {
//        detailRef.addSnapshotListener { snapshot: QuerySnapshot?, exception: FirebaseFirestoreException? ->
//            carList.clear()
//            for(doc in snapshot!!) {
//                carList.add(CarDetails.fromSnapshot(doc))
//            }
//            notifyDataSetChanged()
//        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarDetailViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.cardview_car_detail, parent, false)
        return CarDetailViewHolder(view)
    }

    override fun onBindViewHolder(holder: CarDetailViewHolder, position: Int) {
        holder.bind(carList[position])
    }

    override fun getItemCount(): Int = carList.size

//    fun add(cd: CarDetails) {
//        detailRef.add(cd)
//    }

}