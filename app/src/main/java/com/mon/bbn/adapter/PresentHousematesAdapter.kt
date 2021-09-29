package com.mon.bbn.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources
import androidx.navigation.findNavController
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.recyclerview.widget.RecyclerView
import com.mon.bbn.HomeFragmentDirections
import com.mon.bbn.R
import com.mon.bbn.entity.Contestant
import com.mon.bbn.vm.MainViewModel

class PresentHousematesAdapter(context: Context, contestants: ArrayList<Contestant>, mainViewModel: MainViewModel, imagesRes:HashMap<String, Int>):
    RecyclerView.Adapter<PresentHousematesAdapter.PresentHousematesViewHolder>() {
    private var context = context
    private val contestants = contestants
    private val mainViewModel = mainViewModel
    private val imagesRes = imagesRes

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

    inner class PresentHousematesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        private val imageView: ImageView = itemView.findViewById(R.id.imageView)
        private val textViewName: TextView = itemView.findViewById(R.id.textViewName)
        private val textViewAge: TextView = itemView.findViewById(R.id.textViewAge)
        private val imageButtonFavorite: ImageButton = itemView.findViewById(R.id.imageButtonFavorite)

        fun bind(position: Int){
            itemView.setOnClickListener(this)
            val tag  = contestants[position].tag
            imageView.setImageResource(Contestant.setImage(tag))
            textViewName.text = contestants[position].name
            textViewAge.text = contestants[position].age.toString() + " years"
            if(contestants[position].favorite) {
                //imageButtonFavorite.setImageResource(R.drawable.ic_favorite)
                imageButtonFavorite.background = AppCompatResources.getDrawable(context, R.drawable.ic_favorite)
            }else{
                //imageButtonFavorite.setImageResource(R.drawable.ic_favorite_border)
                imageButtonFavorite.background = AppCompatResources.getDrawable(context, R.drawable.ic_favorite_border)
            }
            //imageButtonFavorite.setBackgroundColor()
        // TODO 1 - setTransitionName
            imageView.transitionName = (imagesRes.get(contestants[position].tag)).toString()
        }

        override fun onClick(view: View?) {
            Toast.makeText(context, "Position Clicked is " + adapterPosition, Toast.LENGTH_SHORT).show()
            val position: Int = adapterPosition

            //TODO 2 - add shared element transition to the navController navigate i.e inform the system that we have a shared element transition.
            // NB: we could pass in several pairs which will be in order but we will just do the imageView first
            //imageView.transitionName = context.getString(R.string.home_image_transition_name)
            val extras = FragmentNavigatorExtras(Pair(imageView, imageView.transitionName))
            val action = HomeFragmentDirections.actionHomeFragmentToDetailsFragment(position)
            view?.findNavController()?.navigate(action, extras)
            // TODO X - postponeEnterTransition will be used instead of setReorderingAllowed(true)
            mainViewModel.setPosition(position)
        }
    }
}