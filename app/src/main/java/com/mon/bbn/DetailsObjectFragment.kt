package com.mon.bbn

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.mon.bbn.R
import com.mon.bbn.data.Status
import com.mon.bbn.entity.Contestant

class DetailsObjectFragment(contestant: Contestant) : Fragment() {
    private val contestant = contestant

    companion object {
        val imageResKey = "IMAGE_RES_KEY"

        fun createInstance(contestant: Contestant, imageRes: String): DetailsObjectFragment {
            val fragment = DetailsObjectFragment(contestant)
            val bundle = Bundle()
            bundle.putString(imageResKey, imageRes)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_detail_object, container, false)

        val imageViewDetail: ImageView = view.findViewById(R.id.imageViewDetail)
        val textViewDetailAge: TextView = view.findViewById(R.id.textViewDetailAge)
        val textViewDetailStatus: TextView = view.findViewById(R.id.textViewDetailStatus)
        val textViewDetailPopularity: TextView = view.findViewById(R.id.textViewDetailPopularity)
        val textViewDetailHighlight: TextView = view.findViewById(R.id.textViewDetailHighlight)
        val textOverlayImageStatus: TextView = view.findViewById(R.id.textOverlayImageStatus)
        val textViewDetailName: TextView = view.findViewById(R.id.textViewDetailName)

        imageViewDetail.setImageResource(R.drawable.boma_placeholder)
        // add a scrim overlay on the image of eliminated contestants
        when (contestant.status) {
            is Status.Active -> textOverlayImageStatus.visibility = GONE
            is Status.Eliminated -> textOverlayImageStatus.visibility = View.VISIBLE
        }

        textViewDetailName.text = contestant.name
        textViewDetailAge.text = contestant.age.toString() + " years"
        textViewDetailStatus.text = contestant.status.currentStatus
        textViewDetailPopularity.text = contestant.popularity.stars
        textViewDetailHighlight.text = contestant.highlight

        //TODO 2: set image Transition name
        val fragmentArguments = arguments
        val imageResString = fragmentArguments?.getString(imageResKey)
        imageViewDetail.transitionName = imageResString

        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }
}