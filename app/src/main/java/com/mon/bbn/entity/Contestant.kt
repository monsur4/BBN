package com.mon.bbn.entity

import com.mon.bbn.data.Popularity
import com.mon.bbn.data.Sex
import com.mon.bbn.data.Status

data class Contestant(var name:String, var age:Int, var sex: Sex, var popularity: Popularity,
                      var status: Status, var highlight:String, var favorite:Boolean ) {
}