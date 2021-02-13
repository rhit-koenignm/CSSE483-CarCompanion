package edu.rosehulman.kaupaies.carcompanion.ui.troubleshooting

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import edu.rosehulman.kaupaies.carcompanion.R
<<<<<<< HEAD

//import kotlinx.android.synthetic.main..view.*
=======
import kotlinx.android.synthetic.main.fragment_diagnosis_details.view.*
>>>>>>> 552093d72e8cfe96013f6db7c4d2f014029bba1e

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_TR = "trouble"

/**
 * A simple [Fragment] subclass.
 * Use the [DocDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DiagnosisDetailsFragment : Fragment() {

    private var trouble: TroubleData? = null

    companion object {
<<<<<<< HEAD
//        @JvmStatic
//        fun newInstance(doc: Doc): DocDetailFragment{
//            val fragment = DocDetailFragment()
//            fragment.arguments = Bundle()
//            fragment.arguments!!.putParcelable(ARG_DOC, doc)
//            return fragment
//        }
=======
        @JvmStatic
        fun newInstance(trouble: TroubleData): DiagnosisDetailsFragment{
            val fragment = DiagnosisDetailsFragment()
            fragment.arguments = Bundle()
            fragment.requireArguments().putParcelable(ARG_TR, trouble)
            return fragment
        }
>>>>>>> 552093d72e8cfe96013f6db7c4d2f014029bba1e
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
<<<<<<< HEAD
//            doc = arguments?.getParcelable(ARG_DOC)
=======
            trouble = arguments?.getParcelable(ARG_TR)
>>>>>>> 552093d72e8cfe96013f6db7c4d2f014029bba1e
        }
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
<<<<<<< HEAD
//        val view = inflater.inflate(R.layout.fragment_doc_detail, container, false)
//        view.fragment_doc_detail_title.text = doc?.title
//        view.fragment_doc_detail_body.text = doc?.text
=======
        val view = inflater.inflate(R.layout.fragment_diagnosis_details, container, false)
        view.fragment_diagnosis_details_title.text = trouble?.title
        view.fragment_diagnosis_detail_body.text = trouble?.text
>>>>>>> 552093d72e8cfe96013f6db7c4d2f014029bba1e

        return view
    }

}