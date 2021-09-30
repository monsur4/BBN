package com.mon.bbn.data

import com.mon.bbn.R
import com.mon.bbn.entity.Contestant
import com.mon.bbn.entity.Season

object DataManager {
    val contestants = ArrayList<Contestant>()
    val seasons = ArrayList<Season>()
    val images = HashMap<String,Int>()

    val loremIpsumText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."

    init{
        initializeContestants()
        initializeSeasons()
        initImageDrawables()
    }

    private fun initializeContestants(){
        // add a few static contestants to the list
        // this would be changed later to use ROOM
        var contestant = Contestant("Boma", 25, Sex.Male(), Popularity.AnyNumber(60), 40,
            Status.Active(), loremIpsumText, false, tag = "boma", "Rivers, Nigeria")
        contestants.add(contestant)

        contestant = Contestant("Saskay", 23, Sex.Female(),  Popularity.AnyNumber(66), 50,
            Status.Eliminated(), loremIpsumText, true, tag = "saskay", "Adamawa, Nigeria")
        contestants.add(contestant)

        contestant = Contestant("WhiteMoney", 28, Sex.Male(),Popularity.AnyNumber(80), 70,
            Status.Active(), loremIpsumText, true, tag = "white_money", "Enugu, Nigeria")
        contestants.add(contestant)

        contestant = Contestant("Nini", 25, Sex.Female(), Popularity.AnyNumber(88), 76,
            Status.Active(), loremIpsumText, false,tag = "nini", "Edo, Nigeria")
        contestants.add(contestant)

        contestant = Contestant("Angel", 24, Sex.Female(), Popularity.AnyNumber(90), 56,
            Status.Active(), loremIpsumText, true, tag = "angel", "Akwa Ibom, Nigeria")
        contestants.add(contestant)
    }

    private fun initializeSeasons(){
        var season = Season(1, 30, "Aliu")
        seasons.add(season)
    season = Season(2, 30, "Bode")
        seasons.add(season)
    season = Season(3, 30, "Chinenye")
        seasons.add(season)
    season = Season(4, 30, "Patrick")
        seasons.add(season)
    season = Season(5, 27, "Lekan")
        seasons.add(season)
    }

    private fun initImageDrawables(){
        // hashmap of image references as ints to identify each imageview unique for transition
        images.put("angel", R.drawable.angel_circle)
        images.put("boma", R.drawable.boma_circle)
        images.put("nini", R.drawable.nini_circle)
        images.put("saskay", R.drawable.saskay_circle)
        images.put("white_money", R.drawable.whitemoney_circle)
    }


}