package com.example.yatzy

import android.util.Log
import java.util.*
//object Settings{
    //var listOfPlayers:MutableList<Player> = mutableListOf()
//}

class Player (var name : String,
              var scoreSheet: MutableList<Score> = mutableListOf(),
              var reRolls : Int = 2,
              var listOfDice: MutableList<Die> = mutableListOf(),
              var score :Int = 0

){

    fun setOnes() {
        var ones = 0
        for (die in listOfDice) {
            if (die.currentValue == 1) {
                ones += 1
            }
        }
        scoreSheet[0].points = ones
        scoreSheet[0].visible = false
    }

    fun setTwos() {
        var twos = 0
        for (die in listOfDice) {
            if (die.currentValue == 2) {
                twos += 2
            }
        }
        scoreSheet[1].points = twos
        scoreSheet[1].visible = false
    }

    fun setThrees() {
        var threes = 0
        for (die in listOfDice) {
            if (die.currentValue == 3) {
                threes += 3
            }
        }
        scoreSheet[2].points = threes
        scoreSheet[2].visible = false
    }

    fun setFours() {
        var fours = 0
        for (die in listOfDice) {
            if (die.currentValue == 4) {
                fours += 4
            }
        }
        scoreSheet[3].points = fours
        scoreSheet[3].visible = false
    }

    fun setFives() {
        var fives = 0
        for (die in listOfDice) {
            if (die.currentValue == 5) {
                fives += 5
            }
        }
        scoreSheet[4].points = fives
        scoreSheet[4].visible = false
    }

    fun setSixes() {
        var sixes = 0
        for (die in listOfDice) {
            if (die.currentValue == 6) {
                sixes += 6
            }
        }
        scoreSheet[5].points = sixes
        scoreSheet[5].visible = false
    }

    fun setOnePair(){
        var points = 0
        val listOfValues : MutableList <Int> = mutableListOf()
        listOfValues.add(listOfDice[0].currentValue)
        listOfValues.add(listOfDice[1].currentValue)
        listOfValues.add(listOfDice[2].currentValue)
        listOfValues.add(listOfDice[3].currentValue)
        listOfValues.add(listOfDice[4].currentValue)
        listOfValues.sortDescending()
        if(listOfValues[0] == listOfValues[1]){
            points = listOfValues[0] + listOfValues[1]
        }else if(listOfValues[1] == listOfValues[2]){
            points = listOfValues[1] + listOfValues[2]
        }else if(listOfValues[2] == listOfValues[3]){
            points = listOfValues[2] + listOfValues[3]
        }else if(listOfValues[3] == listOfValues[4]){
            points = listOfValues[3] + listOfValues[4]
        }
        scoreSheet[8].points = points
        scoreSheet[8].visible = false
    }

    fun setTwoPairs(){
        var points = 0
        val listOfPairs : MutableList<Int> = mutableListOf()
        val listOfValues : MutableList <Int> = mutableListOf()
        listOfValues.add(listOfDice[0].currentValue)
        listOfValues.add(listOfDice[1].currentValue)
        listOfValues.add(listOfDice[2].currentValue)
        listOfValues.add(listOfDice[3].currentValue)
        listOfValues.add(listOfDice[4].currentValue)
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
            points = listOfPairs[0] + listOfPairs[1]
        }
        scoreSheet[9].points = points
    }

    fun setTrips(){
        var points = 0
        val listOfValues : MutableList <Int> = mutableListOf()
        listOfValues.add(listOfDice[0].currentValue)
        listOfValues.add(listOfDice[1].currentValue)
        listOfValues.add(listOfDice[2].currentValue)
        listOfValues.add(listOfDice[3].currentValue)
        listOfValues.add(listOfDice[4].currentValue)
        listOfValues.sortDescending()
        if(listOfValues[0] == listOfValues[1] && listOfValues[0] == listOfValues[2]){
            points = listOfValues[0] + listOfValues[1] + listOfValues[2]
        }else if(listOfValues[1] == listOfValues[2] && listOfValues[1] == listOfValues[3]){
            points = listOfValues[1] + listOfValues[2] + listOfValues[3]
        }else if(listOfValues[2] == listOfValues[3] && listOfValues[2] == listOfValues[4]){
            points = listOfValues[2] + listOfValues[3] + listOfValues[4]
        }
        scoreSheet[10].points = points
    }

    fun setFourOfAKind(){
        var points = 0
        val listOfValues : MutableList <Int> = mutableListOf()
        listOfValues.add(listOfDice[0].currentValue)
        listOfValues.add(listOfDice[1].currentValue)
        listOfValues.add(listOfDice[2].currentValue)
        listOfValues.add(listOfDice[3].currentValue)
        listOfValues.add(listOfDice[4].currentValue)
        listOfValues.sortDescending()
    }


}
