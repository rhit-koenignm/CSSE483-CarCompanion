package edu.rosehulman.kaupaies.carcompanion.ui.troubleshooting

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import edu.rosehulman.kaupaies.carcompanion.R

class TroubleAdapter(var context: Context?, var listener: TroubleshootingFragment.OnTroubleSelectedListener?) : RecyclerView.Adapter<TroubleViewHolder>(){

    var tree = TroubleShootingTree()
    //temporarily gonna use a list of TroubleData

    var woes = ArrayList<TroubleShootingTree.Woe>()

    init {
        woes = TroubleTreeUtils.loadWoes(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TroubleViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.row_view_trouble, parent, false)
        return TroubleViewHolder(view, this)
    }

    override fun onBindViewHolder(holder: TroubleViewHolder, position: Int) {
        holder.bind(woes[position])
    }

    override fun getItemCount(): Int {
        return woes.size
    }

    fun selectTroubleAt(adapterPosition: Int) {
        val currentWoe = woes.get(adapterPosition)
        listener?.onTroubleSelected(currentWoe)
    }



}