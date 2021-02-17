package edu.rosehulman.kaupaies.carcompanion.ui.troubleshooting

import android.content.Context

object TroubleTreeUtils {

    fun loadTroubleTree(context: Context?): TroubleShootingTree{
        return TroubleShootingTree()
    }

     fun loadDiagnoses(context: Context?): ArrayList<TroubleData> {
        val troubles = ArrayList<TroubleData>()
        troubles.add(TroubleData("Faulty Ignition Coil", "Ignition coils work to transfer ignition voltage so that the spark plugs can fire and the engine can start. Some common signs and symptoms of faulty ignition coils include a hard starting car, a car that frequently misfires, and a car that experiences poor acceleration or loses power. Faulty ignition coils usually don't present an immediate safety issue, but it's important to have the problem resolved before further engine damage has a chance to occur."))
        troubles.add(TroubleData("Thermostat Failure", "It's small, it's inexpensive, but it plays a really important role in your vehicle's all-around makeup, especially its engine. For instance, when your thermostat fails, your engine won't work as well as it should. This is largely because these thermostats allow coolant to flow through the greater coolant system. A faulty thermostat could spell bigger engine issues down the road. Good news though: a new thermostat is inexpensive and can be installed fairly easily in less than an hour. How do you know whether or not your thermostat is bad? It's easy to test. Just start up your engine and put your hand on the radiator or its top hose. If it quickly warms up after a moment or two, it's working well. If it warms gradually from the start or doesn't warm up, you should look into thermostat replacement.\n"))
        return troubles
    }

    fun createTree(context: Context?): TroubleShootingTree {
        val troubleTree = TroubleShootingTree()

        return troubleTree
    }

    fun loadWoes(context: Context?): ArrayList<TroubleShootingTree.Woe> {
        var woeList = createIndicators()
        return woeList
    }

    fun createIndicators(): ArrayList<TroubleShootingTree.Woe> {
        var troubleData = ArrayList<TroubleData>()
        troubleData.add(TroubleData("Flashing Light", "There are a variety of warning lights on your dashboard, are any lit?"))
        troubleData.add(TroubleData("Weird Noise", "Is your car making a strange sound?"))
        troubleData.add(TroubleData("Weird Smell", "Is there a strangle smell on the outside or inside of your car?"))
        troubleData.add(TroubleData("Performance Issues", "Is your car having trouble starting or accelerating?"))
        troubleData.add(TroubleData("I see something strange", "Is there smoke coming out of your car?"))
        var type = "Indicator" //These top level ones are indicators so we will have the type as "i"

        var createdIndicators = ArrayList<TroubleShootingTree.Woe>()
        for(trobdata in troubleData){
            val newIndicator = TroubleShootingTree.Indicator(trobdata, "Indicator")
            createdIndicators.add(newIndicator)
        }
        return createdIndicators
    }

    fun createSymptoms() {
        var troubleTitles = arrayListOf<String>("Check Engine ", "Reduced Acceleration")
        var type = "Symptom" //These top level ones are indicators so we will have the type as "i"
    }


}

