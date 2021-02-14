package edu.rosehulman.kaupaies.carcompanion.ui.troubleshooting

import android.content.Context

object TroubleTreeUtils {

    fun loadTroubleTree(context: Context?): TroubleShootingTree{
        return TroubleShootingTree()
    }

     fun loadTroubles(context: Context?): ArrayList<TroubleData> {
        val troubles = ArrayList<TroubleData>()
        troubles.add(TroubleData("Faulty Ignition Coil", "Ignition coils work to transfer ignition voltage so that the spark plugs can fire and the engine can start. Some common signs and symptoms of faulty ignition coils include a hard starting car, a car that frequently misfires, and a car that experiences poor acceleration or loses power. Faulty ignition coils usually don't present an immediate safety issue, but it's important to have the problem resolved before further engine damage has a chance to occur."))
        troubles.add(TroubleData("Thermostat Failure", "It's small, it's inexpensive, but it plays a really important role in your vehicle's all-around makeup, especially its engine. For instance, when your thermostat fails, your engine won't work as well as it should. This is largely because these thermostats allow coolant to flow through the greater coolant system. A faulty thermostat could spell bigger engine issues down the road. Good news though: a new thermostat is inexpensive and can be installed fairly easily in less than an hour. How do you know whether or not your thermostat is bad? It's easy to test. Just start up your engine and put your hand on the radiator or its top hose. If it quickly warms up after a moment or two, it's working well. If it warms gradually from the start or doesn't warm up, you should look into thermostat replacement.\n"))
        return troubles
    }

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

