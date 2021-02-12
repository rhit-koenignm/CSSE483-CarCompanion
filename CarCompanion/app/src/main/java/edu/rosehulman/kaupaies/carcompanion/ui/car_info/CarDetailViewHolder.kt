package edu.rosehulman.kaupaies.carcompanion.ui.car_info

import android.annotation.SuppressLint
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.cardview_car_detail.view.*

class CarDetailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val nicknameTextView = itemView.car_nick_txt as TextView
    private val yearMakeModelTV = itemView.car_ymm_txt as TextView

    init {
//        itemView.setOnClickListener {
//            adapter.highlightFact(adapterPosition)
//        }
    }

    @SuppressLint("SetTextI18n")
    fun bind(carDetails: CarDetails) {
        nicknameTextView.text = carDetails.nickname
        yearMakeModelTV.text = "${carDetails.year} ${carDetails.make} ${carDetails.model}"
//        adapter.setHighlight(itemView, fact.highlighted)
    }


}