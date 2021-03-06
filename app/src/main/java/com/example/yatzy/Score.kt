package com.example.yatzy



abstract class Score(var points: Int = 0, var saved: Boolean = false, )
    {abstract fun saveScore(player : Player)
    }

class Ones : Score(){
    override fun saveScore(player: Player){
        for (die in player.listOfDice) {
            if (die.currentValue == 1) {
                player.scoreSheet[0].points += 1
            }
        }
        player.scoreSheet[0].saved = true
    }
}

class Twos : Score(){
    override fun saveScore(player : Player){
        for (die in player.listOfDice) {
            if (die.currentValue == 2) {
                player.scoreSheet[1].points += 2
            }
        }
        player.scoreSheet[1].saved = true
    }
}

class Threes : Score(){
    override fun saveScore(player : Player){
        for (die in player.listOfDice) {
            if (die.currentValue == 3) {
                player.scoreSheet[2].points += 3
            }
        }
        player.scoreSheet[2].saved = true
    }
}

class Fours : Score(){
    override fun saveScore(player : Player){
        for (die in player.listOfDice) {
            if (die.currentValue == 4) {
                player.scoreSheet[3].points += 4
            }
        }
        player.scoreSheet[3].saved = true
    }
}

class Fives : Score(){
    override fun saveScore(player : Player){
        for (die in player.listOfDice) {
            if (die.currentValue == 5) {
                player.scoreSheet[4].points += 5
            }
        }
        player.scoreSheet[4].saved = true
    }
}

class Sixes : Score(){
    override fun saveScore(player : Player){
        for (die in player.listOfDice) {
            if (die.currentValue == 6) {
                player.scoreSheet[5].points += 6
            }
        }
        player.scoreSheet[5].saved = true
    }
}

class Pair : Score(){
    override fun saveScore(player : Player){
        val listOfValues : MutableList <Int> = mutableListOf()
        for(die in player.listOfDice){
            listOfValues.add(die.currentValue)
        }
        listOfValues.sortDescending()
        if(listOfValues[0] == listOfValues[1]){
            player.scoreSheet[6].points = listOfValues[0] + listOfValues[1]
        }else if(listOfValues[1] == listOfValues[2]){
            player.scoreSheet[6].points = listOfValues[1] + listOfValues[2]
        }else if(listOfValues[2] == listOfValues[3]){
            player.scoreSheet[6].points = listOfValues[2] + listOfValues[3]
        }else if(listOfValues[3] == listOfValues[4]){
            player.scoreSheet[6].points = listOfValues[3] + listOfValues[4]
        }
        player.scoreSheet[6].saved = true
    }
}

class TwoPairs : Score(){
    override fun saveScore(player : Player){
        val listOfPairs : MutableList<Int> = mutableListOf()
        val listOfValues : MutableList <Int> = mutableListOf()
        for(die in player.listOfDice){
            listOfValues.add(die.currentValue)
        }
        listOfValues.sortDescending()
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
            player.scoreSheet[7].points = listOfPairs[0] + listOfPairs[1]
        }
        player.scoreSheet[7].saved = true
    }
}

class ThreeOfAKind : Score(){
    override fun saveScore(player : Player){
        val listOfValues : MutableList <Int> = mutableListOf()
        for(die in player.listOfDice){
            listOfValues.add(die.currentValue)
        }
        listOfValues.sortDescending()
        if(listOfValues[0] == listOfValues[1] && listOfValues[0] == listOfValues[2]){
            player.scoreSheet[8].points = listOfValues[0] + listOfValues[1] + listOfValues[2]
        }else if(listOfValues[1] == listOfValues[2] && listOfValues[1] == listOfValues[3]){
            player.scoreSheet[8].points = listOfValues[1] + listOfValues[2] + listOfValues[3]
        }else if(listOfValues[2] == listOfValues[3] && listOfValues[2] == listOfValues[4]){
            player.scoreSheet[8].points = listOfValues[2] + listOfValues[3] + listOfValues[4]
        }
        player.scoreSheet[8].saved = true
    }
}

class FourOfAKind : Score(){
    override fun saveScore(player : Player){
        val listOfValues : MutableList <Int> = mutableListOf()
        for(die in player.listOfDice){
            listOfValues.add(die.currentValue)
        }
        listOfValues.sortDescending()
        if( listOfValues[0] == listOfValues[1] && listOfValues[0] == listOfValues[2] &&
            listOfValues[0] == listOfValues[3]){
            player.scoreSheet[9].points =   listOfValues[0] + listOfValues[1] +
                                            listOfValues[2] + listOfValues[3]
        }else if(   listOfValues[1] == listOfValues[2] && listOfValues[1] == listOfValues[3] &&
                    listOfValues[1] == listOfValues[4]){
            player.scoreSheet[9].points =   listOfValues[1] + listOfValues[2] +
                                            listOfValues[3] + listOfValues[4]
        }
        player.scoreSheet[9].saved = true
    }
}

class FullHouse : Score(){
    override fun saveScore(player : Player){
        val listOfValues : MutableList <Int> = mutableListOf()
        for(die in player.listOfDice){
            listOfValues.add(die.currentValue)
        }
        listOfValues.sortDescending()
        if(listOfValues[0] == listOfValues[1] && listOfValues[0] == listOfValues[2]){
            if(listOfValues[3] == listOfValues[4]){
                player.scoreSheet[10].points = listOfValues[0] + listOfValues[1] + listOfValues[2] +
                listOfValues[3] + listOfValues[4]
            }
        }else if(listOfValues[0] == listOfValues[1]){
            if(listOfValues[2] == listOfValues[3] && listOfValues[2] == listOfValues[4]){
                player.scoreSheet[10].points = listOfValues[0] + listOfValues[1] + listOfValues[2] +
                listOfValues[3] + listOfValues[4]
            }
        }
        player.scoreSheet[10].saved = true
    }
}

class SmStraight : Score(){
    override fun saveScore(player : Player){
        val listOfValues : MutableList <Int> = mutableListOf()
        for(die in player.listOfDice){
            listOfValues.add(die.currentValue)
        }
        listOfValues.sortDescending()
        if( listOfValues[0] == 5 && listOfValues[1] == 4 && listOfValues[2] == 3 &&
            listOfValues[3] == 2 && listOfValues[4] == 1){
            player.scoreSheet[11].points = 15
        }
        player.scoreSheet[11].saved = true
    }
}

class LgStraight : Score(){
    override fun saveScore(player : Player){
        val listOfValues : MutableList <Int> = mutableListOf()
        for(die in player.listOfDice){
            listOfValues.add(die.currentValue)
        }
        listOfValues.sortDescending()
        if( listOfValues[0] == 6 && listOfValues[1] == 5 && listOfValues[2] == 4 &&
            listOfValues[3] == 3 && listOfValues[4] == 2){
            player.scoreSheet[12].points = 20
        }
        player.scoreSheet[12].saved = true
    }
}

class Chance : Score(){
    override fun saveScore(player : Player){
        for(die in player.listOfDice){
            player.scoreSheet[13].points += die.currentValue
        }
        player.scoreSheet[13].saved = true
    }
}

class Yatzy : Score(){
    override fun saveScore(player : Player){
        val listOfValues : MutableList <Int> = mutableListOf()
        for(die in player.listOfDice){
            listOfValues.add(die.currentValue)
        }
        if( listOfValues[0] == listOfValues[1] && listOfValues[0] == listOfValues[2]  &&
            listOfValues[0] == listOfValues[3] && listOfValues[0] == listOfValues[4]){
            player.scoreSheet[14].points = 50
        }
        player.scoreSheet[14].saved = true
    }
}
class SumOfUpperSection : Score(){
    override fun saveScore(player: Player) {
        player.scoreSheet[15].points =
            player.scoreSheet[0].points +
            player.scoreSheet[1].points +
            player.scoreSheet[2].points +
            player.scoreSheet[3].points +
            player.scoreSheet[4].points +
            player.scoreSheet[5].points
    }
}

class Bonus : Score(){
    override fun saveScore(player: Player) {
        if(player.scoreSheet[15].points >= 63){
            player.scoreSheet[16].points = 50
        }
    }
}

class Total : Score(){
    override fun saveScore(player: Player) {
        player.scoreSheet[17].points =
            player.scoreSheet[6].points +
            player.scoreSheet[7].points +
            player.scoreSheet[8].points +
            player.scoreSheet[9].points +
            player.scoreSheet[10].points +
            player.scoreSheet[11].points +
            player.scoreSheet[12].points +
            player.scoreSheet[13].points +
            player.scoreSheet[14].points +
            player.scoreSheet[15].points +
            player.scoreSheet[16].points

    }
}
