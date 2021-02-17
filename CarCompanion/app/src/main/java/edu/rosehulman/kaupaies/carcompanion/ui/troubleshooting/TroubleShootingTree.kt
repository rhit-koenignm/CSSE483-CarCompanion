@file:Suppress("UNCHECKED_CAST")

package edu.rosehulman.kaupaies.carcompanion.ui.troubleshooting

import android.os.Parcelable
import edu.rosehulman.kaupaies.carcompanion.R
import kotlinx.android.parcel.Parcelize
import kotlinx.android.synthetic.main.fragment_troubleshooting.view.*
import java.util.*
import kotlin.collections.ArrayList

public class TroubleShootingTree {
    //Troubleshooting trees are composed of nodes that referred to as Woes
    //The top level woes at the top of the tree are inidicators and are the most vague form woes as they just help us to narrow down the symptom types
    var indicators = ArrayList<Woe>()
    var symptoms = ArrayList<Woe>()
    var diagnoses = ArrayList<Woe>()

    var currentStep: Int = 0
    var symptomPath = ArrayList<Woe>()

    //temporarily gonna put the troubles in an array list so I can display them and make sure the adapter is working
    var woes = ArrayList<Woe>()
    final var finalStep: Int = 20
    lateinit var currentWoe: Woe

    fun startTroubleShooting(): ArrayList<Woe>{
        //so our currentStep is at 0 but we're going to reset it just in case
        currentStep = 0

        //since this is the beginning, we want to return the indicators
        return indicators
    }

    fun nextStep(selected: Woe): ArrayList<Woe> {
        currentWoe = selected

        if(currentWoe.getType().equals("Symptom")){
            //Adding to the symptom path
            symptomPath.add(currentWoe)
        }

        if(currentWoe.symptoms.isEmpty()){
            //If there are no sub-symptoms, we're going to check if there are any common diagnosis
            if(symptomPath.size < 3){
                //Not enough relevant diagnoses, so we are going to look at another indicator path
                currentStep++
                return indicators.get(this.currentStep).symptoms
            }
            else {
                //We've found enough in common, so we can just return the common diagnoses
                currentStep = finalStep
                return getCommonDiagnoses()
            }
        }

        //If we make it down here, this symptom DOES have sub-symptoms so we should display those
        return currentWoe.symptoms
    }

    fun getStepTitle(): String {
        if(currentStep == 0){
            return R.string.init_trouble_title.toString()
        }
        else if(currentStep < finalStep){
            return currentWoe.getTitle()
        }
        else {
            return R.string.diagnosis_title.toString()
        }
    }

    fun getCommonDiagnoses(): ArrayList<Woe> {
        val commonDiagnoses = (symptomPath.get(0) as Symptom).diagnoses
        var doesContain = true

/*        val indexArray = ArrayList<indexArray>()

        // for loop for firstArray

        for (i in 1..(symptomPath.size - 1)) {
            var nextDiagList = symptomPath.get(i)
            var elementIndex: Int
            var arrayIndex: Int

            // for loop for next ArrayList
            for (i in 1 until nextDiagList.size) {

                if (!nextDiagList[i].contains(e)) {
                    doesContain = false
                    break

                } else {
                    elementIndex = arrayList[i].indexOf(e)
                    arrayIndex = i

                    indexArray.add(indexArray(arrayIndex, elementIndex))
                }
            }

            if (doesContain) {
                commonDiagnoses.add(e)

                // remove element
                for (i in 0 until indexArray.size) {
                    arrayList[indexArray[i].arrayIndex].removeAt(indexArray[i].elementIndex)
                }

                indexArray.clear()

            } else {
                indexArray.clear()
                doesContain = true
            }
        }*/

        return commonDiagnoses as ArrayList<Woe>
    }


    //This is a data class so I can find commonDiagnoses
    internal class indexArray(val arrayIndex: Int, val elementIndex: Int)


    //This section of the code is the actual classes that server as our "nodes"
    open class Woe(val data: TroubleData, open var woeType: String = "Woe") {
        var symptoms = ArrayList<Woe>()

        fun getTitle(): String {
            return this.data.title
        }

        fun getText(): String{
            return this.data.text
        }

        fun getType(): String {
            return woeType
        }

        fun addSymptom(symp: Symptom){
            symptoms.add(symp)
        }

        fun addSymptoms(symps: ArrayList<Symptom>){
            symptoms.addAll(symps)
        }
    }

    class Indicator(data: TroubleData, woeType: String) : Woe(data, woeType){
        override var woeType: String = "Indicator"
    }

    class Symptom(data: TroubleData, woeType: String) : Woe(data, woeType) {
        override var woeType: String = "Symptom"

        lateinit var diagnoses: ArrayList<Woe>

        fun addDiagnosis(diag: Diagnosis){
            diagnoses.add(diag)
        }
    }

    class Diagnosis(data: TroubleData, woeType: String) : Woe(data, woeType) {
        override var woeType: String = "Diagnosis"
    }
}