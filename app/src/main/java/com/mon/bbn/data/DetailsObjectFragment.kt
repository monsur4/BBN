package com.mon.bbn.data

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.mon.bbn.R
import com.mon.bbn.entity.Contestant

class DetailsObjectFragment(contestant: Contestant) : Fragment() {
    private val contestant = contestant
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail_object, container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val imageViewDetail: ImageView = view.findViewById(R.id.imageViewDetail)
        val textViewDetailName: TextView = view.findViewById(R.id.textViewDetailName)
        val textViewDetailAge: TextView = view.findViewById(R.id.textViewDetailAge)
        val textViewDetailStatus: TextView = view.findViewById(R.id.textViewDetailStatus)
        val textViewDetailPopularity: TextView = view.findViewById(R.id.textViewDetailPopularity)
        val textViewDetailHighlight: TextView = view.findViewById(R.id.textViewDetailHighlight)

        imageViewDetail.setImageResource(R.drawable.boma_placeholder)
        // TODO: add a scrim overlay on the image of eliminated contestants
        when(contestant.status){
//            is Status.Eliminated ->
        }

        textViewDetailName.text = contestant.name
        textViewDetailAge.text = contestant.age.toString() + " years"
        textViewDetailStatus.text = contestant.status.currentStatus
        textViewDetailPopularity.text = contestant.popularity.stars
        textViewDetailHighlight.text = contestant.highlight
    }
}