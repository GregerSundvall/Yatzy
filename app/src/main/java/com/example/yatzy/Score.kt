package com.example.yatzy

import android.graphics.drawable.Drawable

abstract class Score(var name: String, var points: Int = 0, var filled: Boolean = false,

){

abstract fun saveScore()


}

class Ones : Score("Ones"){
    override fun saveScore(){
        for (die in Players.listOfPlayers[0].listOfDice) {
            if (die.currentValue == 1) {
                Players.listOfPlayers[0].scoreSheet[0].points += 1
            }
        }
        Players.listOfPlayers[0].scoreSheet[0].filled = false
    }
}