package com.example.yatzy


class Player (var name : String,
              var scoreSheet: MutableList<Score> = mutableListOf(),
              var rolls : Int = 3,
              var listOfDice: MutableList<Die> = mutableListOf(),

){/*
    init{
        scoreSheet.add(Score("Ones"))
        scoreSheet.add(Score("Twos"))
        scoreSheet.add(Score("Threes"))
        scoreSheet.add(Score("Fours"))
        scoreSheet.add(Score("Fives"))
        scoreSheet.add(Score("Sixes"))
        scoreSheet.add(Score("Pair"))
        scoreSheet.add(Score("Two pairs"))
        scoreSheet.add(Score("3 of a kind"))
        scoreSheet.add(Score("4 of a kind"))
        scoreSheet.add(Score("Full house"))
        scoreSheet.add(Score("Sm straight"))
        scoreSheet.add(Score("Lg straight"))
        scoreSheet.add(Score("Chance"))
        scoreSheet.add(Score("Yatzy"))

        for(i in 1..5) {
            listOfDice.add(Die())
        }
    }
*/
    fun setOnes() {
        for (die in listOfDice) {
            if (die.currentValue == 1) {
                scoreSheet[0].points += 2
            }
        }
        scoreSheet[0].filled = false
    }

    fun setTwos() {
        for (die in listOfDice) {
            if (die.currentValue == 2) {
                scoreSheet[1].points += 2
            }
        }
        scoreSheet[1].filled = false
    }

    fun setThrees() {
        for (die in listOfDice) {
            if (die.currentValue == 3) {
                scoreSheet[2].points += 3
            }
        }
        scoreSheet[2].filled = false
    }

    fun setFours() {
        for (die in listOfDice) {
            if (die.currentValue == 4) {
                scoreSheet[3].points += 4
            }
        }
        scoreSheet[3].filled = false
    }

    fun setFives() {
        for (die in listOfDice) {
            if (die.currentValue == 5) {
                scoreSheet[4].points += 5
            }
        }
        scoreSheet[4].filled = false
    }

    fun setSixes() {
        for (die in listOfDice) {
            if (die.currentValue == 6) {
                scoreSheet[5].points += 6
            }
        }
        scoreSheet[5].filled = false
    }

    fun setOnePair(){
        val listOfValues : MutableList <Int> = mutableListOf()
        for(die in listOfDice){
            listOfValues.add(die.currentValue)
        }
        listOfValues.sortDescending()
        if(listOfValues[0] == listOfValues[1]){
            scoreSheet[8].points = listOfValues[0] + listOfValues[1]
        }else if(listOfValues[1] == listOfValues[2]){
            scoreSheet[8].points = listOfValues[1] + listOfValues[2]
        }else if(listOfValues[2] == listOfValues[3]){
            scoreSheet[8].points = listOfValues[2] + listOfValues[3]
        }else if(listOfValues[3] == listOfValues[4]){
            scoreSheet[8].points = listOfValues[3] + listOfValues[4]
        }
        scoreSheet[8].filled = false
    }

    fun setTwoPairs(){
        val listOfPairs : MutableList<Int> = mutableListOf()
        val listOfValues : MutableList <Int> = mutableListOf()
        for(die in listOfDice){
            listOfValues.add(die.currentValue)
        }
        if(listOfValues[0] == listOfValues[1]){
            listOfPairs.add(listOfValues [0] + listOfValues[1])
            if(listOfValues[2] == listOfValues[3]){
                listOfPairs.add(listOfValues[2] + listOfValues[3])
            }else if(listOfValues[3] == listOfValues[4]){
                listOfPairs.add(listOfValues[3] + listOfValues [4])
            }
        }else if(listOfValues[1] == listOfValues[2]){
            listOfPairs.add(listOfValues[1] + listOfValues[2])
            if(listOfValues[3] == listOfValues[4]){
                listOfPairs.add(listOfValues[3] + listOfValues[4])
            }
        }
        if(listOfPairs.size == 2){
            scoreSheet[9].points = listOfPairs[0] + listOfPairs[1]
        }
        scoreSheet[9].filled = false
    }

    fun setTrips(){
        val listOfValues : MutableList <Int> = mutableListOf()
        for(die in listOfDice){
            listOfValues.add(die.currentValue)
        }
        listOfValues.sortDescending()
        if(listOfValues[0] == listOfValues[1] && listOfValues[0] == listOfValues[2]){
            scoreSheet[10].points = listOfValues[0] + listOfValues[1] + listOfValues[2]
        }else if(listOfValues[1] == listOfValues[2] && listOfValues[1] == listOfValues[3]){
            scoreSheet[10].points = listOfValues[1] + listOfValues[2] + listOfValues[3]
        }else if(listOfValues[2] == listOfValues[3] && listOfValues[2] == listOfValues[4]){
            scoreSheet[10].points = listOfValues[2] + listOfValues[3] + listOfValues[4]
        }
        scoreSheet[10].filled = false
    }

    fun setFourOfAKind(){
        val listOfValues : MutableList <Int> = mutableListOf()
        for(die in listOfDice){
            listOfValues.add(die.currentValue)
        }
        listOfValues.sortDescending()
        if(listOfValues[0] == listOfValues[1] && listOfValues[0] == listOfValues[2] && listOfValues[0] == listOfValues[3]){
            scoreSheet[11].points = listOfValues[0] + listOfValues[1] + listOfValues[2] + listOfValues[3]
        }else if(listOfValues[1] == listOfValues[2] && listOfValues[1] == listOfValues[3] && listOfValues[1] == listOfValues[4]){
            scoreSheet[11].points = listOfValues[1] + listOfValues[2] + listOfValues[3] + listOfValues[4]
        }
        scoreSheet[11].filled = false
    }

    fun setFullHouse(){
        val listOfValues : MutableList <Int> = mutableListOf()
        for(die in listOfDice){
            listOfValues.add(die.currentValue)
        }
         listOfValues.sortDescending()
        if(listOfValues[0] == listOfValues[1] && listOfValues[0] == listOfValues[2]){
            if(listOfValues[3] == listOfValues[4]){
                scoreSheet[12].points = listOfValues[0] + listOfValues[1] + listOfValues[2] + listOfValues[3] + listOfValues[4]
            }
        }else if(listOfValues[0] == listOfValues[1]){
            if(listOfValues[2] == listOfValues[3] && listOfValues[2] == listOfValues[4]){
                scoreSheet[12].points = listOfValues[0] + listOfValues[1] + listOfValues[2] + listOfValues[3] + listOfValues[4]
            }
        }
        scoreSheet[12].filled = false
    }

    fun setSmStraight(){
        val listOfValues : MutableList <Int> = mutableListOf()
        for(die in listOfDice){
            listOfValues.add(die.currentValue)
        }
        listOfValues.sortDescending()
        if(listOfValues[0] == 5 && listOfValues[1] == 4 && listOfValues[2] == 3 && listOfValues[3] == 2 && listOfValues[4] == 1){
            scoreSheet[13].points = 15
        }
        scoreSheet[13].filled = false
    }

    fun setLgStraight(){
        val listOfValues : MutableList <Int> = mutableListOf()
        for(die in listOfDice){
            listOfValues.add(die.currentValue)
        }
        listOfValues.sortDescending()
        if(listOfValues[0] == 6 && listOfValues[1] == 5 && listOfValues[2] == 4 && listOfValues[3] == 3 && listOfValues[4] == 2){
            scoreSheet[14].points = 20
        }
        scoreSheet[14].filled = false
    }

    fun setChance(){
        for(die in listOfDice){
            scoreSheet[15].points += die.currentValue
        }
        scoreSheet[15].filled = false
    }

    fun setYatzy(){
        val listOfValues : MutableList <Int> = mutableListOf()
        for(die in listOfDice){
            listOfValues.add(die.currentValue)
        }
        if(listOfValues[0] == listOfValues[1] && listOfValues[0] == listOfValues[2]  && listOfValues[0] == listOfValues[3] && listOfValues[0] == listOfValues[4]){
            scoreSheet[16].points = 50
        }
        scoreSheet[16].filled = false
    }


}
