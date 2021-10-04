package com.mon.bbn.entity

import com.mon.bbn.R

data class Season(var seasonNumber: Int, var numberOfHouseMates: Int, var winner:String, val tag: String) {

    companion object{
        fun setSeasonImage(tag: String) : Int{
            if(tag == "season_one") return R.drawable.season_one
            else if(tag == "season_two") return R.drawable.season_two
            else if(tag == "season_three") return R.drawable.season_three
            else if(tag == "season_four") return R.drawable.season_four
            else if(tag == "season_five") return R.drawable.season_five
            return R.drawable.season_one
        }
    }
}