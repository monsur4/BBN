package com.mon.bbn.entity

import com.mon.bbn.R
import com.mon.bbn.data.Popularity
import com.mon.bbn.data.Sex
import com.mon.bbn.data.Status

data class Contestant(var name:String, var age:Int, var sex: Sex, var popularity: Popularity, var taskCompleted: Int,
                      var status: Status, var bio:String, var favorite:Boolean, val tag:String, var state:String ) {

    companion object{
        // static method for setting each contestant Image
        fun setProfileImage(tag: String) :Int{
            if(tag == "angel") return R.drawable.angel_circle
            else if(tag == "boma") return R.drawable.boma_circle
            else if(tag == "nini") return R.drawable.nini_circle
            else if(tag == "saskay") return R.drawable.saskay_circle
            else if(tag == "white_money") return R.drawable.whitemoney_circle
            else return 0
        }

        fun setBackgroundImage(tag:String) : Int{
            if(tag == "angel") return R.drawable.angel_background
            else if(tag == "boma") return R.drawable.boma_background
            else if(tag == "nini") return R.drawable.nini_background
            else if(tag == "saskay") return R.drawable.saskay_background
            else if(tag == "white_money") return R.drawable.whitemoney_background
            else return 0
        }
    }
}