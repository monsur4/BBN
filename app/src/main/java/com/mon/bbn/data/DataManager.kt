package com.mon.bbn.data

import com.mon.bbn.R
import com.mon.bbn.entity.Contestant
import com.mon.bbn.entity.HOHWinner
import com.mon.bbn.entity.Season
import com.mon.bbn.entity.WeeksHOHWinner

object DataManager {
    val contestants = ArrayList<Contestant>()
    val seasons = ArrayList<Season>()
    val images = HashMap<String,Int>()
    val winnersOfHOH = ArrayList<WeeksHOHWinner>()

    val loremIpsumText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."

    init{
        initializeContestants()
        initializeSeasons()
        initImageDrawables()
        initWinnersOfHOH()
    }

    // consider having all contestant details as a constant val
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

    private fun initWinnersOfHOH(){
//        var winner = HOHWinner("Peace", 24, Contestant.PEACE)
        // week 1
        var listOfWinners = ArrayList<HOHWinner>()
        listOfWinners.add(HOHWinner("Peace", 24, Contestant.PEACE))
        var weeksHOHWinner = WeeksHOHWinner(1, 1, listOfWinners)
        winnersOfHOH.add(weeksHOHWinner)

        // week 2
        listOfWinners = ArrayList<HOHWinner>()
        listOfWinners.add(HOHWinner("Boma", 25, Contestant.BOMA))
        weeksHOHWinner = WeeksHOHWinner(2, 1, listOfWinners)
        winnersOfHOH.add(weeksHOHWinner)

        // week 3
        listOfWinners = ArrayList<HOHWinner>()
        listOfWinners.add(HOHWinner("Pere", 25, Contestant.PERE))
        weeksHOHWinner = WeeksHOHWinner(3, 1, listOfWinners)
        winnersOfHOH.add(weeksHOHWinner)

        // week 4
        listOfWinners = ArrayList<HOHWinner>()
        listOfWinners.add(HOHWinner("Maria", 25, Contestant.MARIA))
        weeksHOHWinner = WeeksHOHWinner(4, 1, listOfWinners)
        winnersOfHOH.add(weeksHOHWinner)

        // week 5
        listOfWinners = ArrayList<HOHWinner>()
        listOfWinners.add(HOHWinner("WhiteMoney", 25, Contestant.WHITE_MONEY))
        weeksHOHWinner = WeeksHOHWinner(5, 1, listOfWinners)
        winnersOfHOH.add(weeksHOHWinner)

        // week 6
        listOfWinners = ArrayList<HOHWinner>()
        listOfWinners.add(HOHWinner("JayPaul", 25, Contestant.JAY_PAUL))
        listOfWinners.add(HOHWinner("JackieB", 25, Contestant.JACKIE_B))
        weeksHOHWinner = WeeksHOHWinner(6, 2, listOfWinners)
        winnersOfHOH.add(weeksHOHWinner)

        // week 7
        listOfWinners = ArrayList<HOHWinner>()
        listOfWinners.add(HOHWinner("Emmanuel", 25, Contestant.EMMANUEL))
        weeksHOHWinner = WeeksHOHWinner(7, 1, listOfWinners)
        winnersOfHOH.add(weeksHOHWinner)

        // week 8
        listOfWinners = ArrayList<HOHWinner>()
        listOfWinners.add(HOHWinner("WhiteMoney", 25, Contestant.WHITE_MONEY))
        weeksHOHWinner = WeeksHOHWinner(8, 1, listOfWinners)
        winnersOfHOH.add(weeksHOHWinner)

        // week 9
        listOfWinners = ArrayList<HOHWinner>()
        listOfWinners.add(HOHWinner("Emmanuel", 25, Contestant.EMMANUEL))
        weeksHOHWinner = WeeksHOHWinner(9, 1, listOfWinners)
        winnersOfHOH.add(weeksHOHWinner)
    }

}