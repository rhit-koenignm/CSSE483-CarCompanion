package edu.rosehulman.kaupaies.carcompanion

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TroubleshootingFragment : Fragment() {


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?): View? {

        var view = inflater.inflate(R.layout.fragment_troubleshooting, container, false)
//        view.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
//        adapter = FactViewAdapter(context, factProvider, this, review)
//        view.adapter = adapter
//        view.layoutManager = LinearLayoutManager(context)
//        view.setHasFixedSize(true)
        return view

    }

}
