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
        var contestant = Contestant("Boma", 34, Sex.Male(), Popularity.AnyNumber(60), 40,
            Status.Active(), loremIpsumText, false, tag = Contestant.BOMA, "Rivers, Nigeria")
        contestants.add(contestant)

        contestant = Contestant("Saskay", 22, Sex.Female(),  Popularity.AnyNumber(66), 50,
            Status.Eliminated(), loremIpsumText, true, tag = Contestant.SASKAY, "Adamawa, Nigeria")
        contestants.add(contestant)

        contestant = Contestant("WhiteMoney", 29, Sex.Male(),Popularity.AnyNumber(80), 70,
            Status.Active(), loremIpsumText, true, tag = Contestant.WHITE_MONEY, "Enugu, Nigeria")
        contestants.add(contestant)

        contestant = Contestant("Nini", 27, Sex.Female(), Popularity.AnyNumber(88), 76,
            Status.Active(), loremIpsumText, false,tag = Contestant.NINI, "Edo, Nigeria")
        contestants.add(contestant)

        contestant = Contestant("Angel", 21, Sex.Female(), Popularity.AnyNumber(90), 56,
            Status.Active(), loremIpsumText, true, tag = Contestant.ANGEL, "Akwa Ibom, Nigeria")
        contestants.add(contestant)

        contestant = Contestant("Cross", 30, Sex.Male(), Popularity.AnyNumber(90), 56,
            Status.Eliminated(), loremIpsumText, true, tag = Contestant.CROSS, "Anambra, Nigeria")
        contestants.add(contestant)

        contestant = Contestant("Emmanuel", 24, Sex.Male(), Popularity.AnyNumber(60), 52,
            Status.Eliminated(), loremIpsumText, false, tag = Contestant.EMMANUEL, "Akwa Ibom, Nigeria")
        contestants.add(contestant)

        contestant = Contestant("Liquorose", 26, Sex.Female(), Popularity.AnyNumber(76), 72,
            Status.Active(), loremIpsumText, true, tag = Contestant.LIQUOROSE, "Edo, Nigeria")
        contestants.add(contestant)

        contestant = Contestant("Saga", 28, Sex.Male(), Popularity.AnyNumber(86), 78,
            Status.Active(), loremIpsumText, true, tag = Contestant.SAGA, "Lagos, Nigeria")
        contestants.add(contestant)

        contestant = Contestant("Maria", 29, Sex.Female(), Popularity.AnyNumber(64), 63,
            Status.Eliminated(), "A former Air Hostess", true, tag = Contestant.MARIA, "Imo, Nigeria")
        contestants.add(contestant)

        contestant = Contestant("Peace", 26, Sex.Female(), Popularity.AnyNumber(54), 78,
            Status.Eliminated(), loremIpsumText, false, tag = Contestant.PEACE, "Rivers, Nigeria")
        contestants.add(contestant)

        contestant = Contestant("Jay Paul", 29, Sex.Male(), Popularity.AnyNumber(70), 67,
            Status.Eliminated(), loremIpsumText, false, tag = Contestant.JAY_PAUL, "Cross River, Nigeria")
        contestants.add(contestant)

        contestant = Contestant("Niyi", 33, Sex.Male(), Popularity.AnyNumber(67), 45,
            Status.Eliminated(), "A Computer Engineer who loves basketball", true, tag = Contestant.NIYI, "Oyo, Nigeria")
        contestants.add(contestant)

        contestant = Contestant("Arin", 29, Sex.Female(), Popularity.AnyNumber(68), 57,
            Status.Eliminated(), loremIpsumText, true, tag = Contestant.ARIN, "Ekiti, Nigeria")
        contestants.add(contestant)

        contestant = Contestant("Beatrice", 28, Sex.Female(), Popularity.AnyNumber(70), 76,
            Status.Active(), "A talented software developer", false, tag = Contestant.BEATRICE, "Rivers, Nigeria")
        contestants.add(contestant)

        contestant = Contestant("Pere", 35, Sex.Male(), Popularity.AnyNumber(82), 60,
            Status.Active(), loremIpsumText, true, tag = Contestant.PERE, "---, Nigeria")
        contestants.add(contestant)


        contestant = Contestant("Yousef", 29, Sex.Male(), Popularity.AnyNumber(75), 80,
            Status.Active(), "A teacher and graduate of University of Jos", true, tag = Contestant.YOUSEF, "Nasarawa, Nigeria")
        contestants.add(contestant)

        contestant = Contestant("Jackie B", 29, Sex.Female(), Popularity.AnyNumber(80), 82,
            Status.Active(), loremIpsumText, true, tag = Contestant.JACKIE_B, "Adamawa, Nigeria")
        contestants.add(contestant)

        contestant = Contestant("Sammie", 26, Sex.Male(), Popularity.AnyNumber(67), 50,
            Status.Eliminated(), loremIpsumText, false, tag = Contestant.SAMMIE, "Kaduna, Nigeria")
        contestants.add(contestant)

        contestant = Contestant("Princess", 30, Sex.Female(), Popularity.AnyNumber(89), 84,
            Status.Eliminated(), loremIpsumText, true, tag = Contestant.PRINCESS, "Imo, Nigeria")
        contestants.add(contestant)

        contestant = Contestant("Tega", 29, Sex.Female(), Popularity.AnyNumber(79), 60,
            Status.Eliminated(), loremIpsumText, false, tag = Contestant.TEGA, "Cross River, Nigeria")
        contestants.add(contestant)

        contestant = Contestant("Micheal", 29, Sex.Male(), Popularity.AnyNumber(52), 90,
            Status.Eliminated(), loremIpsumText, true, tag = Contestant.MICHEAL, "---, Nigeria")
        contestants.add(contestant)

        contestant = Contestant("JMK", 23, Sex.Female(), Popularity.AnyNumber(76), 83,
            Status.Active(), "A law graduate of UNILORIN", true, tag = Contestant.JMK, "Kwara, Nigeria")
        contestants.add(contestant)

        contestant = Contestant("Kayvee", 26, Sex.Male(), Popularity.AnyNumber(89), 34,
            Status.Eliminated(), "First Housemate to leave the house", false, tag = Contestant.KAYVEE, "Ogun, Nigeria")
        contestants.add(contestant)

        contestant = Contestant("Yerins", 21, Sex.Male(), Popularity.AnyNumber(70), 75,
            Status.Eliminated(), "A medical doctor", true, tag = Contestant.YERINS, "---, Nigeria")
        contestants.add(contestant)

        contestant = Contestant("Queen", 26, Sex.Female(), Popularity.AnyNumber(73), 65,
            Status.Active(), loremIpsumText, false, tag = Contestant.QUEEN, "Akwa Ibom, Nigeria")
        contestants.add(contestant)
    }

    private fun initializeSeasons(){
        var season = Season(1, 30, "Katung Aduwak", "season_one")
        seasons.add(season)
    season = Season(2, 30, "Micheal Ejeba", "season_two")
        seasons.add(season)
    season = Season(3, 30, "Miracle Igbokwe", "season_three")
        seasons.add(season)
    season = Season(4, 30, "Mercy Eke", "season_four")
        seasons.add(season)
    season = Season(5, 27, "Laycon", "season_five")
        seasons.add(season)
    }

    //TODO
    private fun initImageDrawables(){
        // hashmap of image references as ints to identify each imageview unique for transition
        images.put(Contestant.ANGEL, R.drawable.angel_circle)
        images.put(Contestant.BOMA, R.drawable.boma_circle)
        images.put(Contestant.NINI, R.drawable.nini_circle)
        images.put(Contestant.SASKAY, R.drawable.saskay_circle)
        images.put(Contestant.WHITE_MONEY, R.drawable.whitemoney_circle)
        images.put(Contestant.CROSS, R.drawable.cross_profile)
        images.put(Contestant.NIYI, R.drawable.niyi_profile)
        images.put(Contestant.SAGA, R.drawable.saga_profile)
        images.put(Contestant.SAMMIE, R.drawable.sammie_profile)
        images.put(Contestant.YERINS, R.drawable.yerins_profile)
        images.put(Contestant.YOUSEF, R.drawable.yousef_profile)
        images.put(Contestant.ARIN, R.drawable.arin_profile)
        images.put(Contestant.BEATRICE, R.drawable.beatrice_profile)
        images.put(Contestant.LIQUOROSE, R.drawable.liqourose_profile)
        images.put(Contestant.PRINCESS, R.drawable.princess_profile)
        images.put(Contestant.TEGA, R.drawable.tega_profile)
        images.put(Contestant.MICHEAL, R.drawable.micheal_profile)
        images.put(Contestant.JMK, R.drawable.jmk_profile)
        images.put(Contestant.KAYVEE, R.drawable.kayvee_profile)
        images.put(Contestant.QUEEN, R.drawable.queen_profile)
        images.put(Contestant.PEACE, R.drawable.peace_profile)
        images.put(Contestant.PERE, R.drawable.pere_profile)
        images.put(Contestant.MARIA, R.drawable.maria_profile)
        images.put(Contestant.JAY_PAUL, R.drawable.jaypaul_profile)
        images.put(Contestant.JACKIE_B, R.drawable.jackieb_profile)
        images.put(Contestant.EMMANUEL, R.drawable.emmanuel_profile)
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
        listOfWinners.add(HOHWinner("Jay Paul", 25, Contestant.JAY_PAUL))
        listOfWinners.add(HOHWinner("Jackie B", 25, Contestant.JACKIE_B))
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