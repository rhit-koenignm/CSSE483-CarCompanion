package edu.rosehulman.kaupaies.carcompanion.ui.find_help

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import edu.rosehulman.kaupaies.carcompanion.R

class FindHelpFragment: Fragment() {
    lateinit var myMapView: MapView
    private lateinit var googleMap: GoogleMap

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var v = inflater.inflate(R.layout.fragment_find_help, container, false)
        myMapView = v.findViewById(R.id.map_view)
        myMapView.onCreate(savedInstanceState)
        myMapView.onResume()
        //we need this for our map to show up

//        try {
//            MapsInitializer.initialize(activity.getApplicationContext())
//        }
//        }
//
//        Log.d(Constants.TAG, "opened find help map")
//        view.layoutManager = LinearLayoutManager(context)
//        view.setHasFixedSize(true)\

        return v
    }

    override fun onResume() {
        super.onResume()
        myMapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        myMapView.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        myMapView.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        myMapView.onLowMemory()
    }

}