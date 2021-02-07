package edu.rosehulman.kaupaies.carcompanion.ui.troubleshooting

class TroubleShootingTree {


    class Woe {
        var name: String = ""
        var  tribulations: ArrayList<Woe> = ArrayList<Woe>()

        constructor(newName: String, givenTribs: ArrayList<Woe>){
            name = newName
            tribulations =  givenTribs
        }

        public addTrib(givenWoe: Woe){
            tribulations.add(givenWoe)
        }
    }
}