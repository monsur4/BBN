package com.mon.bbn.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.TransitionSet
import com.mon.bbn.HomeFragmentDirections
import com.mon.bbn.R
import com.mon.bbn.entity.Contestant
import com.mon.bbn.vm.MainViewModel

class PresentHousematesAdapter(fragment: Fragment, contestants: ArrayList<Contestant>, mainViewModel: MainViewModel, imagesRes:HashMap<String, Int>):
    RecyclerView.Adapter<PresentHousematesAdapter.PresentHousematesViewHolder>() {
    private val fragment = fragment
    private var context = fragment.context
    private val contestants = contestants
    private val mainViewModel = mainViewModel
    private val imagesRes = imagesRes

//    private interface ImageLoaderListener{
//        fun onLoadCompleted(imageView: ImageView, position: Int)
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PresentHousematesViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.card_view_present_housemates,parent, false)
        return PresentHousematesViewHolder(view)
    }

    override fun onBindViewHolder(holder: PresentHousematesViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return contestants.size
    }

    // an implementation of the ImageLoaderListener, once images have been loaded that we can start enter transition

//        inner class ImageLoaderListenerImpl(fragment: Fragment, ) : ImageLoaderListener{
//                val fragment = fragment
//            val enterTransitionStarted = AtomicBoolean()
//
//            override fun onLoadCompleted(imageView: ImageView, position: Int) {
//                if()
//
//fragment.startPostponedEnterTransition()            }
//
//
//    }

    inner class PresentHousematesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        private val imageView: ImageView = itemView.findViewById(R.id.imageView)
        private val textViewName: TextView = itemView.findViewById(R.id.textViewName)
        private val textViewAge: TextView = itemView.findViewById(R.id.textViewAge)
        private val imageButtonFavorite: ImageButton = itemView.findViewById(R.id.imageButtonFavorite)

        fun bind(position: Int){
            itemView.setOnClickListener(this)
            val tag  = contestants[position].tag
            imageView.setImageResource(Contestant.setProfileImage(tag))
            textViewName.text = contestants[position].name
            textViewAge.text = contestants[position].age.toString() + " years"
            if(contestants[position].favorite) {
                //imageButtonFavorite.setImageResource(R.drawable.ic_favorite)
                imageButtonFavorite.background = AppCompatResources.getDrawable(context!!, R.drawable.ic_favorite)
            }else{
                //imageButtonFavorite.setImageResource(R.drawable.ic_favorite_border)
                imageButtonFavorite.background = AppCompatResources.getDrawable(context!!, R.drawable.ic_favorite_border)
            }
            //imageButtonFavorite.setBackgroundColor()
        // TODO 1 - setTransitionName
            imageView.transitionName = ("${imagesRes.get(contestants[position].tag)}_image").toString()
            imageButtonFavorite.transitionName = ("${imagesRes.get(contestants[position].tag)}_favorite").toString()


//            begin startPostponedEnterTransition once the position is in view
            if(mainViewModel.getPosition() == position){
                fragment.startPostponedEnterTransition()
            }
        }

        override fun onClick(view: View?) {
            val position: Int = adapterPosition

            //TODO 2 - add shared element transition to the navController navigate i.e inform the system that we have a shared element transition.
            // NB: we could pass in several pairs which will be in order but we will just do the imageView first
            //imageView.transitionName = context.getString(R.string.home_image_transition_name)
            val extras = FragmentNavigatorExtras(
                Pair(imageView, imageView.transitionName),
                Pair(imageButtonFavorite, imageButtonFavorite.transitionName)
            )
            // exclude the selected view from the exit transition
            (fragment.exitTransition as TransitionSet).excludeTarget(itemView, true)
            val action = HomeFragmentDirections.actionHomeFragmentToDetailsFragment(position)
            view?.findNavController()?.navigate(action, extras)
            // TODO X - postponeEnterTransition will be used instead of setReorderingAllowed(true)
            mainViewModel.setPosition(position)
        }

    }
}