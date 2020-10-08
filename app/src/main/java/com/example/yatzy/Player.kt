package com.example.yatzy


class Player (var name : String,
              var scoreSheet: MutableList<Score> = mutableListOf(),
              var rolls : Int = 3,
              var listOfDice: MutableList<Die> = mutableListOf(),
              var alreadySaved : Boolean = false

){
    init{
        scoreSheet.add(Ones())
        scoreSheet.add(Twos())
        scoreSheet.add(Threes())
        scoreSheet.add(Fours())
        scoreSheet.add(Fives())
        scoreSheet.add(Sixes())
        scoreSheet.add(Pair())
        scoreSheet.add(TwoPairs())
        scoreSheet.add(ThreeOfAKind())
        scoreSheet.add(FourOfAKind())
        scoreSheet.add(FullHouse())
        scoreSheet.add(SmStraight())
        scoreSheet.add(LgStraight())
        scoreSheet.add(Chance())
        scoreSheet.add(Yatzy())
        scoreSheet.add(SumOfTopSection())
        scoreSheet.add(Bonus())
        scoreSheet.add(Total())
    }
}
