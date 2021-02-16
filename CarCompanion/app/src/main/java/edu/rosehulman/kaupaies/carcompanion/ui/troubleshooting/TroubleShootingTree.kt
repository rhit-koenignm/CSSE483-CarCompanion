package edu.rosehulman.kaupaies.carcompanion.ui.troubleshooting

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*
import kotlin.collections.ArrayList

public class TroubleShootingTree {
    //Troubleshooting trees are composed of nodes that referred to as Woes
    //The top level woes at the top of the tree are inidicators and are the most vague form woes as they just help us to narrow down the symptom types
    var indicators = ArrayList<Woe>()
    var symptoms = ArrayList<Woe>()
    var diagnoses = ArrayList<Woe>()

    var currentStep: Int = 0
    var symptomPath = Stack<Symptom>()

    //temporarily gonna put the troubles in an array list so I can display them and make sure the adapter is working
    var woes = ArrayList<Woe>()



    fun nextStep(selected: Woe): ArrayList<Woe> {


        if(currentStep == 0) {
            //This means we are at the first step, where we want to display the indicator themselves first
            currentStep++
            return indicators
        }
        else if(currentStep < indicators.size){
            //This means we are still in the troubleshooting stage where we looking at the
            currentStep++
            return indicators.get(this.currentStep).symptoms
        }
        else {
            //This means we are looking at a diagnosis so our
            currentStep = 0
            return diagnoses(symptomPath)
        }
    }




    //This section of the code is the actual classes that server as our "nodes"
    open class Woe(val data: TroubleData, open var woeType: String = "Woe") {

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

    class Indicator(data: TroubleData, woeType: String) : Woe(data, woeType){
        override var woeType: String = "Indicator"

        //Indicators have a
        var symptoms = ArrayList<Woe>()

        fun addSymptom(symp: Symptom){
            symptoms.add(symp)
        }

        fun addSymptoms(symps: ArrayList<Symptom>){
            symptoms.addAll(symps)
        }
    }

    class Symptom(data: TroubleData, woeType: String) : Woe(data, woeType) {
        override var woeType: String = "Symptom"
    }

    class Diagnosis(data: TroubleData, woeType: String) : Woe(data, woeType) {
        override var woeType: String = "Diagnosis"

        //Indicators have a
        var symptoms = ArrayList<Woe>()

        fun addSymptom(symp: Symptom){
            symptoms.add(symp)
        }

        fun addSymptoms(symps: ArrayList<Symptom>){
            symptoms.addAll(symps)
        }

    }


}