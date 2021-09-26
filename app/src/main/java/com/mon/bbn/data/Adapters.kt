package com.mon.bbn.data

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mon.bbn.R

class PresentHousematesAdapter(context: Context, contestants: ArrayList<Contestant>):
    RecyclerView.Adapter<PresentHousematesAdapter.PresentHousematesViewHolder>() {
    private var context = context
    private val contestants = contestants

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
            imageView.setImageResource(R.drawable.boma_placeholder)
            textViewName.text = contestants[position].name
            textViewAge.text = contestants[position].age.toString() + " years"
            if(contestants[position].favorite) {
                imageButtonFavorite.setImageResource(R.drawable.ic_favorite)
            }else{
                imageButtonFavorite.setImageResource(R.drawable.ic_favorite_border)
            }
        }

        override fun onClick(p0: View?) {
            TODO("Open up the new Activity and pass along the adapter position")
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

        override fun onClick(p0: View?) {
            TODO("Not yet implemented")
        }
    }

}