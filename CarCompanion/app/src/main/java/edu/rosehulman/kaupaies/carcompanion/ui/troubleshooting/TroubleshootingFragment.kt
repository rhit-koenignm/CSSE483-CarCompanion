package edu.rosehulman.kaupaies.carcompanion.ui.troubleshooting

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.rosehulman.kaupaies.carcompanion.R
import java.lang.RuntimeException

class TroubleshootingFragment : Fragment() {

    private var listener: OnTroubleSelectedListener? = null

    lateinit var recylclerParent: RecyclerView

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_troubleshooting, container, false) as RecyclerView
        val adapter = TroubleAdapter(context, listener)
        view.adapter = adapter
        view.layoutManager = LinearLayoutManager(context)
        view.setHasFixedSize(true)
        return view
    }

    override fun onAttach(context: Context){
        super.onAttach(context)
        if(context is OnTroubleSelectedListener){
            listener = context
        } else {
//            throw RuntimeException(context.toString() + "must implement OnTroubleSelected")
        }
    }

    override fun onDetach(){
        super.onDetach()
        listener = null
    }

    interface OnTroubleSelectedListener {
        fun onTroubleSelected(woe: TroubleShootingTree.Woe){

        }
    }

}
