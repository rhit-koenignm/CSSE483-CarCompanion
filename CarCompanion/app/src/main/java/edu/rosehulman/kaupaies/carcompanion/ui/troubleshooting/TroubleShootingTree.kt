package edu.rosehulman.kaupaies.carcompanion.ui.troubleshooting

class TroubleShootingTree {
    //Troubleshooting trees are composed of nodes that referred to as Woes
    //The top level woes at the top of the tree are inidicators and are the most vague form woes as they just help us to narrow down the

    class Woe {
        var name: String = ""
        var symptoms = ArrayList<Woe>()
        var type: String = ""

        constructor(newName: String, givenSymptoms: ArrayList<Woe>, ){
            name = newName
            symptoms =  givenSymptoms
        }


    }


}