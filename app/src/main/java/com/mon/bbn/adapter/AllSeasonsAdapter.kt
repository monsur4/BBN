package com.mon.bbn.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.mon.bbn.R
import com.mon.bbn.entity.Season

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