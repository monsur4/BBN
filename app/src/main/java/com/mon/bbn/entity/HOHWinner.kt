package com.mon.bbn.entity

data class HOHWinner(val name: String,
                     val age: Int,
                     val tag: String,
                     val winningWeeks: ArrayList<Int> = ArrayList<Int>()) {
}