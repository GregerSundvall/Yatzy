package com.example.yatzy

import android.graphics.drawable.Drawable
import android.util.Log

abstract class Score(var name: String, var points: Int = 0, var filled: Boolean = false,

){

abstract fun saveScore(player : Player)


}

class Ones : Score("Ones"){
    override fun saveScore(player: Player){
        Log.d("!!!", "saveScore started")
        for (die in player.listOfDice) {
            if (die.currentValue == 1) {
                player.scoreSheet[0].points += 1
            }
        }
        player.scoreSheet[0].filled = true
    }
}

class Twos : Score("Twos"){
    override fun saveScore(player : Player){
        for (die in player.listOfDice) {
            if (die.currentValue == 2) {
                player.scoreSheet[1].points += 2
            }
        }
        player.scoreSheet[1].filled = true
    }
}

class Threes : Score("Threes"){
    override fun saveScore(player : Player){
        for (die in player.listOfDice) {
            if (die.currentValue == 3) {
                player.scoreSheet[2].points += 3
            }
        }
        player.scoreSheet[2].filled = true
    }
}

class Fours : Score("Fours"){
    override fun saveScore(player : Player){
        for (die in player.listOfDice) {
            if (die.currentValue == 4) {
                player.scoreSheet[3].points += 4
            }
        }
        player.scoreSheet[3].filled = true
    }
}

class Fives : Score("Fives"){
    override fun saveScore(player : Player){
        for (die in player.listOfDice) {
            if (die.currentValue == 5) {
                player.scoreSheet[4].points += 5
            }
        }
        player.scoreSheet[4].filled = true
    }
}

class Sixes : Score("Sixes"){
    override fun saveScore(player : Player){
        for (die in player.listOfDice) {
            if (die.currentValue == 6) {
                player.scoreSheet[5].points += 6
            }
        }
        player.scoreSheet[5].filled = true
    }
}

class Pair : Score("Pair"){
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
        player.scoreSheet[6].filled = true
    }
}

class TwoPairs : Score("Two pairs"){
    override fun saveScore(player : Player){
        val listOfPairs : MutableList<Int> = mutableListOf()
        val listOfValues : MutableList <Int> = mutableListOf()
        for(die in player.listOfDice){
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
            player.scoreSheet[7].points = listOfPairs[0] + listOfPairs[1]
        }
        player.scoreSheet[7].filled = true
    }
}

class ThreeOfAKind : Score("3 of a kind"){
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
        player.scoreSheet[8].filled = true
    }
}

class FourOfAKind : Score("4 of a kind"){
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
        player.scoreSheet[9].filled = true
    }
}

class FullHouse : Score("Full house"){
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
        player.scoreSheet[10].filled = true
    }
}

class SmStraight : Score("Small straight"){
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
        player.scoreSheet[11].filled = true
    }
}

class LgStraight : Score("Large straight"){
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
        player.scoreSheet[12].filled = true
    }
}

class Chance : Score("Chance"){
    override fun saveScore(player : Player){
        for(die in player.listOfDice){
            player.scoreSheet[13].points += die.currentValue
        }
        player.scoreSheet[13].filled = true
    }
}

class Yatzy : Score("Yatzy"){
    override fun saveScore(player : Player){
        val listOfValues : MutableList <Int> = mutableListOf()
        for(die in player.listOfDice){
            listOfValues.add(die.currentValue)
        }
        if( listOfValues[0] == listOfValues[1] && listOfValues[0] == listOfValues[2]  &&
            listOfValues[0] == listOfValues[3] && listOfValues[0] == listOfValues[4]){
            player.scoreSheet[14].points = 50
        }
        player.scoreSheet[14].filled = true
    }
}
