package com.mon.bbn.entity

import com.mon.bbn.R
import com.mon.bbn.data.Popularity
import com.mon.bbn.data.Sex
import com.mon.bbn.data.Status

data class Contestant(var name:String, var age:Int, var sex: Sex, var popularity: Popularity, var taskCompleted: Int,
                      var status: Status, var bio:String, var favorite:Boolean, val tag:String, var state:String ) {

    companion object{
        const val ANGEL : String = "angel"
        const val BOMA : String = "boma"
        const val NINI : String = "nini"
        const val SASKAY : String = "saskay"
        const val WHITE_MONEY : String = "white_money"
        const val PEACE : String = "peace"
        const val PERE : String = "pere"
        const val MARIA : String = "maria"
        const val JAY_PAUL : String = "jay_paul"
        const val JACKIE_B : String = "jackie_b"
        const val EMMANUEL : String = "emmanuel"

        // static method for setting each contestant Image
        fun setProfileImage(tag: String) :Int{
            if(tag == ANGEL) return R.drawable.angel_circle
            else if(tag == BOMA) return R.drawable.boma_circle
            else if(tag == NINI) return R.drawable.nini_circle
            else if(tag == SASKAY) return R.drawable.saskay_circle
            else if(tag == WHITE_MONEY) return R.drawable.whitemoney_circle
            else return R.drawable.boma_circle // bomas image is our default image
        }

        fun setBackgroundImage(tag:String) : Int{
            if(tag == ANGEL) return R.drawable.angel_background
            else if(tag == BOMA) return R.drawable.boma_background
            else if(tag == NINI) return R.drawable.nini_background
            else if(tag == SASKAY) return R.drawable.saskay_background
            else if(tag == WHITE_MONEY) return R.drawable.whitemoney_background
            else return R.drawable.boma_background // bomas image is our default image
        }
    }
}