package edu.rosehulman.kaupaies.carcompanion.ui.troubleshooting

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.rosehulman.kaupaies.carcompanion.Constants
import edu.rosehulman.kaupaies.carcompanion.R

class TroubleshootingFragment : Fragment() {

    private var listener: OnTroubleSelectedListener? = null

    lateinit var recylclerParent: RecyclerView

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        var relativeView = inflater.inflate(R.layout.fragment_troubleshooting, container, false)
        var view = relativeView.findViewById<RecyclerView>(R.id.troubleshooting_recycler)
        Log.d(Constants.TAG, "opened troubleshooter")
        val adapter = TroubleAdapter(context, listener)
        view.adapter = adapter
        view.layoutManager = LinearLayoutManager(context)
        view.setHasFixedSize(true)

        var restart_trouble_button = relativeView.findViewById<Button>(R.id.restart_button)
        restart_trouble_button.setOnClickListener {
            Log.d(Constants.TAG, "restart button pressed")
            adapter.restartTroubleshooting()
        }

        var back_step_button = relativeView.findViewById<Button>(R.id.back_step_button)
        back_step_button.setOnClickListener {
            Log.d(Constants.TAG, "back step button pressed")
        }

        var next_step_button = relativeView.findViewById<Button>(R.id.next_step_button)
        next_step_button.setOnClickListener {
            Log.d(Constants.TAG, "next step button pressed")
        }

        return relativeView
    }

    override fun onAttach(context: Context){
        super.onAttach(context)
        Log.d(Constants.TAG, "attempting to attach troubleshoot")
        if(context is OnTroubleSelectedListener){
            listener = context
        } else {
            throw RuntimeException(context.toString() + "must implement OnTroubleSelected")
        }
    }

    override fun onDetach(){
        super.onDetach()
        listener = null
    }

    interface OnTroubleSelectedListener {
        fun onTroubleSelected(woe: TroubleShootingTree.Woe)
    }

}
