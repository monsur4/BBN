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
        const val CROSS : String = "cross"
        const val NIYI : String = "niyi"
        const val SAGA : String = "saga"
        const val SAMMIE : String = "sammie"
        const val YERINS : String = "yerins"
        const val YOUSEF : String = "yousef"
        const val ARIN : String = "arin"
        const val BEATRICE : String = "beatrice"
        const val LIQUOROSE : String = "liquorose"
        const val PRINCESS : String = "princess"
        const val NINI : String = "nini"
        const val SASKAY : String = "saskay"
        const val TEGA : String = "tega"
        const val MICHEAL : String = "micheal"
        const val JMK : String = "jmk"
        const val KAYVEE : String = "kayvee"
        const val QUEEN : String = "queen"
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
            else if(tag == CROSS) return R.drawable.cross_profile
            else if(tag == NIYI) return R.drawable.niyi_profile
            else if(tag == SAGA) return R.drawable.saga_profile
            else if(tag == SAMMIE) return R.drawable.sammie_profile
            else if(tag == YERINS) return R.drawable.yerins_profile
            else if(tag == YOUSEF) return R.drawable.yousef_profile
            else if(tag == ARIN) return R.drawable.arin_profile
            else if(tag == BEATRICE) return R.drawable.beatrice_profile
            else if(tag == LIQUOROSE) return R.drawable.liqourose_profile
            else if(tag == PRINCESS) return R.drawable.princess_profile
            else if(tag == TEGA) return R.drawable.tega_profile
            else if(tag == MICHEAL) return R.drawable.micheal_profile
            else if(tag == JMK) return R.drawable.jmk_profile
            else if(tag == KAYVEE) return R.drawable.kayvee_profile
            else if(tag == QUEEN) return R.drawable.queen_profile
            else if(tag == PEACE) return R.drawable.peace_profile
            else if(tag == PERE) return R.drawable.pere_profile
            else if(tag == MARIA) return R.drawable.maria_profile
            else if(tag == JAY_PAUL) return R.drawable.jaypaul_profile
            else if(tag == JACKIE_B) return R.drawable.jackieb_profile
            else if(tag == EMMANUEL) return R.drawable.emmanuel_profile
            else return R.drawable.boma_circle // bomas image is our default image
        }

        fun setBackgroundImage(tag:String) : Int{
            if(tag == ANGEL) return R.drawable.angel_background
            else if(tag == BOMA) return R.drawable.boma_background
            else if(tag == NINI) return R.drawable.nini_background
            else if(tag == SASKAY) return R.drawable.saskay_background
            else if(tag == WHITE_MONEY) return R.drawable.whitemoney_background
            else if(tag == CROSS) return R.drawable.cross_background
            else if(tag == NIYI) return R.drawable.niyi_background
            else if(tag == SAGA) return R.drawable.saga_background
            else if(tag == SAMMIE) return R.drawable.sammie_background
            else if(tag == YERINS) return R.drawable.yerins_background
            else if(tag == YOUSEF) return R.drawable.yousef_background
            else if(tag == ARIN) return R.drawable.arin_background
            else if(tag == BEATRICE) return R.drawable.beatrice_background
            else if(tag == LIQUOROSE) return R.drawable.liqourose_background
            else if(tag == PRINCESS) return R.drawable.princess_background
            else if(tag == TEGA) return R.drawable.tega_background
            else if(tag == MICHEAL) return R.drawable.micheal_background
            else if(tag == JMK) return R.drawable.jmk_background
            else if(tag == KAYVEE) return R.drawable.kayvee_background
            else if(tag == QUEEN) return R.drawable.queen_background
            else if(tag == PEACE) return R.drawable.peace_background
            else if(tag == PERE) return R.drawable.pere_background
            else if(tag == MARIA) return R.drawable.maria_background
            else if(tag == JAY_PAUL) return R.drawable.jaypaul_background
            else if(tag == JACKIE_B) return R.drawable.jackieb_background
            else if(tag == EMMANUEL) return R.drawable.emmanuel_background
            else return R.drawable.boma_background // bomas image is our default image
        }
    }
}