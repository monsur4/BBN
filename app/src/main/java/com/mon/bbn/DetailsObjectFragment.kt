package com.mon.bbn

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import android.view.animation.AnticipateInterpolator
import android.view.animation.DecelerateInterpolator
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.transition.TransitionSet
import com.mon.bbn.data.Status
import com.mon.bbn.entity.Contestant

class DetailsObjectFragment( contestant: Contestant) : Fragment() {
    private val contestant = contestant

    companion object {
        val imageResKey = "IMAGE_RES_KEY"

        fun createInstance(contestant: Contestant, imageRes: String): DetailsObjectFragment {
            val fragment = DetailsObjectFragment( contestant)
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

        val imageViewDetailProfile: ImageView = view.findViewById(R.id.imageViewDetailProfile)
        val imageViewDetailBackground: ImageView = view.findViewById(R.id.imageViewDetailBackground)
        val textViewDetailAge: TextView = view.findViewById(R.id.textViewDetailAge)
        val textViewDetailState: TextView = view.findViewById(R.id.textVIewDetailState)
        val textViewDetailBio: TextView = view.findViewById(R.id.textViewDetailBio)
        val textOverlayImageStatus: TextView = view.findViewById(R.id.textOverlayImageStatus)
        val textViewDetailName: TextView = view.findViewById(R.id.textViewDetailName)
        val progressBarDetailPopularity: ProgressBar = view.findViewById(R.id.progressBarDetailPopularity)
        val textViewDetailPopularity: TextView = view.findViewById(R.id.textViewDetailPopularity)
        val progressBarDetailTasksCompleted: ProgressBar = view.findViewById(R.id.progressBarDetailTasksCompleted)
        val textViewDetailTasksCompleted: TextView = view.findViewById(R.id.textViewDetailTasksCompleted)
        val imageButtonDetailFavorite: ImageButton = view.findViewById(R.id.imageButtonDetailFavorite)

        imageViewDetailProfile.setImageResource(Contestant.setProfileImage(contestant.tag))
        imageViewDetailBackground.setImageResource(Contestant.setBackgroundImage(contestant.tag))
        // add a scrim overlay on the image of eliminated contestants
        when (contestant.status) {
            is Status.Active -> textOverlayImageStatus.visibility = GONE
            is Status.Eliminated -> {
                ObjectAnimator.ofInt(textOverlayImageStatus, "visibility", View.VISIBLE).apply {
                    interpolator = AnticipateInterpolator()
                    duration = 3000
                    startDelay = 3000
                }
            }
        }

        textViewDetailName.text = contestant.name
        textViewDetailAge.text = contestant.age.toString() + " years"
        textViewDetailState.text = contestant.state
        textViewDetailBio.text = contestant.bio
        ObjectAnimator.ofInt(progressBarDetailPopularity, "progress", contestant.popularity.value).apply{
            duration = 3000
            interpolator = DecelerateInterpolator()
            start()
        }
        textViewDetailPopularity.text = "${contestant.popularity.value}%"

        ObjectAnimator.ofInt(progressBarDetailTasksCompleted, "progress", contestant.taskCompleted).apply{
            duration = 3000
            interpolator = DecelerateInterpolator()
            start()
        }
        textViewDetailTasksCompleted.text = "${contestant.taskCompleted}%"

        // set favorite icon
        if(contestant.favorite){
            imageButtonDetailFavorite.setBackgroundResource(R.drawable.ic_favorite)
        }else{
            imageButtonDetailFavorite.setBackgroundResource(R.drawable.ic_favorite_border)
        }

        //TODO 2: set image Transition name
        val fragmentArguments = arguments
        val imageResString = fragmentArguments?.getString(imageResKey)
        imageViewDetailProfile.transitionName = "{$imageResString}_image"
        imageButtonDetailFavorite.transitionName = "{$imageResString}_favorite"

        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }
}