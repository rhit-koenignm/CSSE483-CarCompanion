package edu.rosehulman.kaupaies.carcompanion.ui.troubleshooting

import android.content.Context

object TroubleTreeUtils {
    //fun loadTroubleTree(context: Context?): TroubleShootingTree {
        //Will be implementing

    //}

    fun createTree() {


    }

    fun createTopLevelTroubles() {
        var troubleTitles = arrayListOf<String>("Flashing Light", "Weird Noise", "Weird Smell")
        var type = "i" //These top level ones are indicators so we will have the type as "i"

    }

    fun createSymptomLevelTroubles() {
        var troubleTitles = arrayListOf<String>("Check Engine ", "Reduced Acceleration")
        var type = "i" //These top level ones are indicators so we will have the type as "i"
    }


}