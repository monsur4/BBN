package com.mon.bbn.data

import android.content.Context
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
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.mon.bbn.DetailsObjectFragment
import com.mon.bbn.HomeFragmentDirections
import com.mon.bbn.R
import com.mon.bbn.entity.Contestant
import com.mon.bbn.entity.Season
import com.mon.bbn.vm.MainViewModel

class PresentHousematesAdapter(context: Context, contestants: ArrayList<Contestant>, mainViewModel: MainViewModel):
    RecyclerView.Adapter<PresentHousematesAdapter.PresentHousematesViewHolder>() {
    private var context = context
    private val contestants = contestants
    private val mainViewModel = mainViewModel

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
            imageView.setImageResource(R.drawable.boma_placeholder)
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
        }

        override fun onClick(view: View?) {
            Toast.makeText(context, "Position Clicked is " + adapterPosition, Toast.LENGTH_SHORT).show()
            val position: Int = adapterPosition
            val action = HomeFragmentDirections.actionHomeFragmentToDetailsFragment(position)
            view?.findNavController()?.navigate(action)
            mainViewModel.setPosition(position)
        }
    }
}

class AllSeasonsAdapter(context: Context, seasons:ArrayList<Season>) :
    RecyclerView.Adapter<AllSeasonsAdapter.AllSeasonsViewHolder>() {
    private val context = context
    private val seasons =seasons


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllSeasonsViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.card_view_season, parent, false)
        return AllSeasonsViewHolder(view)
    }

    override fun onBindViewHolder(holder: AllSeasonsViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return seasons.size
    }

    inner class AllSeasonsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener{
        private val imageView: ImageView = itemView.findViewById(R.id.imageViewSeason)
        private val textView: TextView = itemView.findViewById(R.id.textViewSeason)

        fun bind(position: Int){
            imageView.setImageResource(R.drawable.season_5)
            textView.text = "Season " + seasons[position].seasonNumber
        }

        override fun onClick(view: View?) {
            Toast.makeText(context, "Feature not yet implemented", Toast.LENGTH_SHORT).show()
        }
    }
}

class DetailsFragmentViewPagerAdapter(fragment: Fragment, contestants:ArrayList<Contestant>, mainViewModel: MainViewModel)
    :FragmentStateAdapter(fragment){
    private val contestants = contestants
    private val mainViewModel = mainViewModel
    override fun getItemCount(): Int {
        return contestants.size
    }

    override fun createFragment(position: Int): Fragment {
        val contestant = contestants[position]
        val fragment = DetailsObjectFragment(contestant)

        return fragment
    }

}