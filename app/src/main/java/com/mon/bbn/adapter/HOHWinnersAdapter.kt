package com.mon.bbn.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mon.bbn.R
import com.mon.bbn.entity.Contestant
import com.mon.bbn.entity.WeeksHOHWinner

class HOHWinnersAdapter(context: Context, winnersOfHOH: ArrayList<WeeksHOHWinner>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    val context = context
    val weekWinnersOfHOH = winnersOfHOH
    val SINGLE_WINNER_LAYOUT = 1
    val DOUBLE_WINNER_LAYOUT = 2
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if(viewType == SINGLE_WINNER_LAYOUT){
            SingleLayoutViewHolder(
                LayoutInflater.from(context).inflate(R.layout.item_hoh_single_winner, parent, false)
            )
        }else
            DoubleLayoutViewHolder(
                LayoutInflater.from(context).inflate(R.layout.item_hoh_double_winners, parent, false)
            )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(getItemViewType(position) == SINGLE_WINNER_LAYOUT) {
            (holder as SingleLayoutViewHolder).bind(position)
        }else{
            (holder as DoubleLayoutViewHolder).bind(position)
        }
    }

    override fun getItemCount(): Int {
        return weekWinnersOfHOH.size
    }

    override fun getItemViewType(position: Int): Int {
        val week = weekWinnersOfHOH.get(position)
        return if(week.noOfHOH > 1){
            DOUBLE_WINNER_LAYOUT
        }else SINGLE_WINNER_LAYOUT
    }

    inner class SingleLayoutViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val imageViewSingleHOH: ImageView = itemView.findViewById(R.id.imageViewSingleHOH)
        private val textViewName: TextView = itemView.findViewById(R.id.textViewNameSingleHOH)
        private val textViewAge: TextView = itemView.findViewById(R.id.textViewAgeSingleHOH)
        private val textViewWeek: TextView = itemView.findViewById(R.id.textViewWeekSingleHOH)

        fun bind(position : Int){
            val week = weekWinnersOfHOH[position]
            val winner = week.hohWinners[0]
            imageViewSingleHOH.setImageResource(Contestant.setProfileImage(winner.tag))
            textViewName.text = winner.name
            textViewAge.text = "${(winner.age.toString())} years"
            textViewWeek.text = "Week ${(week.weekNo.toString())}"
        }
    }

    inner class DoubleLayoutViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val imageViewFirstDoubleHOH: ImageView = itemView.findViewById(R.id.imageViewFirstDoubleHOH)
        private val textViewNameFirstDoubleHOH: TextView = itemView.findViewById(R.id.textViewNameFirstDoubleHOH)
        private val textViewAgeFirstDoubleHOH: TextView = itemView.findViewById(R.id.textViewAgeFirstDoubleHOH)

        private val imageViewSecondDoubleHOH: ImageView = itemView.findViewById(R.id.imageViewSecondDoubleHOH)
        private val textViewNameSecondDoubleHOH: TextView = itemView.findViewById(R.id.textViewNameSecondDoubleHOH)
        private val textViewAgeSecondDoubleHOH: TextView = itemView.findViewById(R.id.textViewAgeSecondDoubleHOH)

        private val textViewWeek: TextView = itemView.findViewById(R.id.textViewWeekDoubleHOH)

        fun bind(position:Int){
            val week = weekWinnersOfHOH[position]
            val firstWinner = week.hohWinners[0]
            imageViewFirstDoubleHOH.setImageResource(Contestant.setProfileImage(firstWinner.tag))
            textViewNameFirstDoubleHOH.text = firstWinner.name
            textViewAgeFirstDoubleHOH.text = "${(firstWinner.age.toString())} years"

            val secondWinner = week.hohWinners[1]
            imageViewSecondDoubleHOH.setImageResource(Contestant.setProfileImage(secondWinner.tag))
            textViewNameSecondDoubleHOH.text = secondWinner.name
            textViewAgeSecondDoubleHOH.text = "${(secondWinner.age.toString())} years"

            textViewWeek.text = "Week ${(week.weekNo.toString())}"
        }
    }
}