package com.mon.bbn.data

sealed class Popularity(var num: Int) {

    val stars:String = convertNumberToStarString(num)

    class ZeroStar(num: Int = 0) : Popularity(num)
    class OneStar(num: Int = 1) : Popularity(num)
    class TwoStar(num: Int = 2) : Popularity(num)
    class ThreeStar(num: Int = 3) : Popularity(num)
    class FourStar(num: Int = 4) : Popularity(num)
    class FiveStar(num: Int = 5) : Popularity(num)

    companion object{
        private const val blackStar = "\u2605"
        private const val whiteStar = "\u2606"
        fun convertNumberToStarString(num: Int): String {
            var starString = ""
            var count = 0
            for(n in 1..num){
                starString += blackStar
                count++
            }
            /*var n = 0
            while(n<num){
                starString += blackStar
                n++
                count++
            }*/
            while(count<6){
                starString += whiteStar
                count++
            }
            return starString
        }
    }



    fun convertNumberToPopularity(num: Int): Popularity {
        return Popularity.ZeroStar()
    }
}

sealed class Status(var currentStatus: String){
    class Eliminated(currentStatus: String = "Eliminated"):Status(currentStatus)
    class Active(currentStatus:String = "Active"):Status(currentStatus)

    fun checkPopularity(popularity: Popularity){
        when(popularity){
            is Popularity.OneStar -> println("Contestant is unpopular")
            is Popularity.TwoStar -> println("Contestant is not so popular")
            is Popularity.ThreeStar -> println("Contestant is fairly popular")
            is Popularity.FourStar -> println("Contestant is quite popular")
            is Popularity.FiveStar -> println("Contestant is very popular")
        }
    }
}

sealed class Sex{
    class Male:Sex()
    class Female:Sex()
}