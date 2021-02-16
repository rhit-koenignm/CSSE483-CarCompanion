package edu.rosehulman.kaupaies.carcompanion.ui.troubleshooting

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

public class TroubleShootingTree {
    //Troubleshooting trees are composed of nodes that referred to as Woes
    //The top level woes at the top of the tree are inidicators and are the most vague form woes as they just help us to narrow down the symptom types
    var indicators = ArrayList<Woe>()
    var diagnoses = ArrayList<Diagnosis>()


    //temporarily gonna put the troubles in an array list so I can display them and make sure the adapter is working
    var woes = ArrayList<Woe>()




    public interface Woe {
        var data: TroubleData
        var woeType: String

        fun getTitle(): String {
            return this.data.title
        }

        fun getText(): String{
            return this.data.text
        }

        fun getType(): String {
            return woeType
        }
    }

    class Symptom : Woe {
        override lateinit var data: TroubleData
        override var woeType: String = "Symptom"

        constructor()
    }

    class Diagnosis : Woe {
        override lateinit var data: TroubleData
        override var woeType: String = "Diagnosis"

        constructor(givenData: TroubleData, givenType: String){

        }

        @JvmName("getDiagnosisData")
        fun getData(): TroubleData{
            return data
        }
    }


}