package edu.rosehulman.kaupaies.carcompanion.ui.troubleshooting

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

class TroubleShootingTree {
    //Troubleshooting trees are composed of nodes that referred to as Woes
    //The top level woes at the top of the tree are inidicators and are the most vague form woes as they just help us to narrow down the symptom types

    //temporarily gonna put the troubles in an array list so I can display them and make sure the adapter is working
    var woes = ArrayList<Woe>()

    public class Woe {
        lateinit var data: TroubleData
        //var symptoms: ArrayList<Woe>
        var type: String = ""

        constructor(givenData: TroubleData, groupType: String) {
            this.data = givenData
            type = groupType
        }

        @JvmName("getData1")
        fun getData(): TroubleData{
            return data
        }

        fun getTitle(): String {
            return this.data.title
        }

        fun getText(): String{
            return this.data.text
        }
    }

    public class Diagnosis {
        var name: String = ""
        var signs = ArrayList<Woe>()
        var text: String = ""

        constructor(newName: String, givenSymptoms: ArrayList<Woe>){

        }
    }


}