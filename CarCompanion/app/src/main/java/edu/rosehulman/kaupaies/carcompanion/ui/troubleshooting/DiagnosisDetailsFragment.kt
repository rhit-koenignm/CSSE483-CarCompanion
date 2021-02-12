package edu.rosehulman.kaupaies.carcompanion.ui.troubleshooting

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
//import kotlinx.android.synthetic.main..view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_DOC = "doc"

/**
 * A simple [Fragment] subclass.
 * Use the [DocDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DocDetailFragment : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance(doc: Doc): DocDetailFragment{
            val fragment = DocDetailFragment()
            fragment.arguments = Bundle()
            fragment.arguments!!.putParcelable(ARG_DOC, doc)
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            doc = arguments?.getParcelable(ARG_DOC)
        }
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_doc_detail, container, false)
        view.fragment_doc_detail_title.text = doc?.title
        view.fragment_doc_detail_body.text = doc?.text

        return view
    }

}