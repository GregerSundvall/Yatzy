package com.example.yatzy

import android.graphics.drawable.Drawable

abstract class Score(var name: String, var points: Int = 0, var filled: Boolean = false,

){

abstract fun saveScore(player : Player)


}

class Ones : Score("Ones"){
    override fun saveScore(player : Player){
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
        for (die in player.listOfDice) {
            if (die.currentValue == 1) {
                player.scoreSheet[0].points += 1
            }
        }
        player.scoreSheet[0].filled = true
    }
}

class TwoPairs : Score("Two pairs"){
    override fun saveScore(player : Player){
        for (die in player.listOfDice) {
            if (die.currentValue == 1) {
                player.scoreSheet[0].points += 1
            }
        }
        player.scoreSheet[0].filled = true
    }
}

class ThreeOfAKind : Score("3 of a kind"){
    override fun saveScore(player : Player){
        for (die in player.listOfDice) {
            if (die.currentValue == 1) {
                player.scoreSheet[0].points += 1
            }
        }
        player.scoreSheet[0].filled = true
    }
}

class FourOfAKind : Score("4 of a kind"){
    override fun saveScore(player : Player){
        for (die in player.listOfDice) {
            if (die.currentValue == 1) {
                player.scoreSheet[0].points += 1
            }
        }
        player.scoreSheet[0].filled = true
    }
}

class FullHouse : Score("Full house"){
    override fun saveScore(player : Player){
        for (die in player.listOfDice) {
            if (die.currentValue == 1) {
                player.scoreSheet[0].points += 1
            }
        }
        player.scoreSheet[0].filled = true
    }
}

class SmStraight : Score("Small straight"){
    override fun saveScore(player : Player){
        for (die in player.listOfDice) {
            if (die.currentValue == 1) {
                player.scoreSheet[0].points += 1
            }
        }
        player.scoreSheet[0].filled = true
    }
}

class LgStraight : Score("Large straight"){
    override fun saveScore(player : Player){
        for (die in player.listOfDice) {
            if (die.currentValue == 1) {
                player.scoreSheet[0].points += 1
            }
        }
        player.scoreSheet[0].filled = true
    }
}

class Chance : Score("Chance"){
    override fun saveScore(player : Player){
        for (die in player.listOfDice) {
            if (die.currentValue == 1) {
                player.scoreSheet[0].points += 1
            }
        }
        player.scoreSheet[0].filled = true
    }
}

class Yatzy : Score("Yatzy"){
    override fun saveScore(player : Player){
        for (die in player.listOfDice) {
            if (die.currentValue == 1) {
                player.scoreSheet[0].points += 1
            }
        }
        player.scoreSheet[0].filled = true
    }
}
