package edu.rosehulman.kaupaies.carcompanion.ui.troubleshooting

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import edu.rosehulman.kaupaies.carcompanion.R

class TroubleAdapter(var context: Context?, var listener: TroubleshootingFragment.OnTroubleSelectedListener?) : RecyclerView.Adapter<TroubleViewHolder>(){

    var tree = TroubleShootingTree()
    //temporarily gonna use a list of Woes

    var woes = ArrayList<TroubleShootingTree.Woe>()

    init {
        //tree = TroubleTreeUtils.loadTroubleTree(context)
        woes = TroubleTreeUtils.loadWoes(context)
        add(woes)
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

    fun stepThruTree(adapterPosition: Int){
        removeWoes()
        add(tree.nextStep(woes.get(adapterPosition)))
    }

    fun removeWoes() {
        while(!woes.isEmpty()){
            woes.removeAt(0)
            notifyItemRemoved(0)
        }
    }

    fun add(w: ArrayList<TroubleShootingTree.Woe>){
        removeWoes()

        for(i in 1..w.size){
            woes.add(i, w.get(i))
        }

    }

}