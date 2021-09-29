package com.mon.bbn.entity

import com.mon.bbn.R
import com.mon.bbn.data.Popularity
import com.mon.bbn.data.Sex
import com.mon.bbn.data.Status

data class Contestant(var name:String, var age:Int, var sex: Sex, var popularity: Popularity,
                      var status: Status, var highlight:String, var favorite:Boolean, val tag:String ) {

    companion object{
        // static method for setting each contestant Image
        fun setImage(tag: String) :Int{
            if(tag == "angel") return R.drawable.angel_circle
            else if(tag == "boma") return R.drawable.boma_circle
            else if(tag == "nini") return R.drawable.nini_circle
            else if(tag == "saskay") return R.drawable.saskay_circle
            else if(tag == "white_money") return R.drawable.whitemoney_circle
            else return 0
        }
    }
}