package com.example.yatzy

import android.util.Log
import java.util.*


class Player (var name : String,
              var scoreSheet: MutableList<Score> = mutableListOf(),
              var rolls : Int = 3,
              var listOfDice: MutableList<Die> = mutableListOf(),

){

    fun setOnes() {
        for (die in listOfDice) {
            if (die.currentValue == 1) {
                scoreSheet[0].points += 2
            }
        }
        scoreSheet[0].visible = false
    }

    fun setTwos() {
        for (die in listOfDice) {
            if (die.currentValue == 2) {
                scoreSheet[1].points += 2
            }
        }
        scoreSheet[1].visible = false
    }

    fun setThrees() {
        for (die in listOfDice) {
            if (die.currentValue == 3) {
                scoreSheet[2].points += 3
            }
        }
        scoreSheet[2].visible = false
    }

    fun setFours() {
        for (die in listOfDice) {
            if (die.currentValue == 4) {
                scoreSheet[3].points += 4
            }
        }
        scoreSheet[3].visible = false
    }

    fun setFives() {
        for (die in listOfDice) {
            if (die.currentValue == 5) {
                scoreSheet[4].points += 5
            }
        }
        scoreSheet[4].visible = false
    }

    fun setSixes() {
        for (die in listOfDice) {
            if (die.currentValue == 6) {
                scoreSheet[5].points += 6
            }
        }
        scoreSheet[5].visible = false
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
        scoreSheet[8].visible = false
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
        scoreSheet[9].visible = false
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
        scoreSheet[10].visible = false
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
        scoreSheet[11].visible = false
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
        scoreSheet[12].visible = false
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
        scoreSheet[13].visible = false
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
        scoreSheet[14].visible = false
    }

    fun setChance(){
        for(die in listOfDice){
            scoreSheet[15].points += die.currentValue
        }
        scoreSheet[15].visible = false
    }

    fun setYatzy(){
        val listOfValues : MutableList <Int> = mutableListOf()
        for(die in listOfDice){
            listOfValues.add(die.currentValue)
        }
        if(listOfValues[0] == listOfValues[1] && listOfValues[0] == listOfValues[2]  && listOfValues[0] == listOfValues[3] && listOfValues[0] == listOfValues[4]){
            scoreSheet[16].points = 50
        }
        scoreSheet[16].visible = false
    }


}
