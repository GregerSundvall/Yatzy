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
              var warning: Int = 0,
              var warningOnes: Int = 0,
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
    }

    fun setTwos() {
        var twos = 0
        for (die in listOfDice) {
            if (die.currentValue == 2) {
                twos += 2
            }
        }
        scoreSheet[1].points = twos
    }

    fun setThrees() {
        var threes = 0
        for (die in listOfDice) {
            if (die.currentValue == 3) {
                threes += 3
            }
        }
        scoreSheet[2].points = threes
    }

    fun setFours() {
        var fours = 0
        for (die in listOfDice) {
            if (die.currentValue == 4) {
                fours += 4
            }
        }
        scoreSheet[3].points = fours
    }

    fun setFives() {
        var fives = 0
        for (die in listOfDice) {
            if (die.currentValue == 5) {
                fives += 5
            }
        }
        scoreSheet[4].points = fives
    }

    fun setSixes() {
        var sixes = 0
        for (die in listOfDice) {
            if (die.currentValue == 6) {
                sixes += 6
            }
        }
        scoreSheet[5].points = sixes
    }



    /*
    fun setOnePair(){
        val listOfPairs :MutableList<Int> = mutableListOf()
        if(listOfDice[0].currentValue == listOfDice[1].currentValue){
            listOfPairs.add (listOfDice[0].currentValue + listOfDice[1].currentValue)
        }
        if(listOfDice[0].currentValue == listOfDice[2].currentValue){
            listOfPairs.add (listOfDice[0].currentValue + listOfDice[2].currentValue)
        }
        if(listOfDice[0].currentValue == listOfDice[3].currentValue){
            listOfPairs.add (listOfDice[0].currentValue + listOfDice[3].currentValue)
        }
        if(listOfDice[0].currentValue == listOfDice[4].currentValue){
            listOfPairs.add (listOfDice[0].currentValue + listOfDice[4].currentValue)
        }
        if(listOfDice[1].currentValue == listOfDice[2].currentValue) {
            listOfPairs.add (listOfDice[1].currentValue + listOfDice[2].currentValue)
        }
        if(listOfDice[1].currentValue == listOfDice[3].currentValue){
            listOfPairs.add (listOfDice[1].currentValue + listOfDice[3].currentValue)
        }
        if(listOfDice[1].currentValue == listOfDice[4].currentValue){
            listOfPairs.add (listOfDice[1].currentValue + listOfDice[4].currentValue)
        }
        if(listOfDice[2].currentValue == listOfDice[3].currentValue) {
            listOfPairs.add (listOfDice[2].currentValue + listOfDice[3].currentValue)
        }
        if(listOfDice[2].currentValue == listOfDice[4].currentValue) {
            listOfPairs.add (listOfDice[2].currentValue + listOfDice[4].currentValue)
        }
        if(listOfDice[3].currentValue == listOfDice[4].currentValue) {
            listOfPairs.add (listOfDice[3].currentValue + listOfDice[4].currentValue)
        }
        listOfPairs.sortDescending()
        if(listOfPairs[0] == 0){
         //Detta ger ingen poäng. Stryka?
            }else {
            scoreSheet[8] = listOfPairs[0]
            }
        }

    fun setTwoPairs(){
        val listOfPairs :MutableList<Int> = mutableListOf()
        if(listOfDice[0].currentValue == listOfDice[1].currentValue){
            listOfPairs.add (listOfDice[0].currentValue + listOfDice[1].currentValue)
        }
        if(listOfDice[0].currentValue == listOfDice[2].currentValue){
            listOfPairs.add (listOfDice[0].currentValue + listOfDice[2].currentValue)
        }
        if(listOfDice[0].currentValue == listOfDice[3].currentValue){
            listOfPairs.add (listOfDice[0].currentValue + listOfDice[3].currentValue)
        }
        if(listOfDice[0].currentValue == listOfDice[4].currentValue){
            listOfPairs.add (listOfDice[0].currentValue + listOfDice[4].currentValue)
        }
        if(listOfDice[1].currentValue == listOfDice[2].currentValue) {
            listOfPairs.add (listOfDice[1].currentValue + listOfDice[2].currentValue)
        }
        if(listOfDice[1].currentValue == listOfDice[3].currentValue){
            listOfPairs.add (listOfDice[1].currentValue + listOfDice[3].currentValue)
        }
        if(listOfDice[1].currentValue == listOfDice[4].currentValue){
            listOfPairs.add (listOfDice[1].currentValue + listOfDice[4].currentValue)
        }
        if(listOfDice[2].currentValue == listOfDice[3].currentValue) {
            listOfPairs.add (listOfDice[2].currentValue + listOfDice[3].currentValue)
        }
        if(listOfDice[2].currentValue == listOfDice[4].currentValue) {
            listOfPairs.add (listOfDice[2].currentValue + listOfDice[4].currentValue)
        }
        if(listOfDice[3].currentValue == listOfDice[4].currentValue) {
            listOfPairs.add (listOfDice[3].currentValue + listOfDice[4].currentValue)
        }
        listOfPairs.sortDescending()
        if(listOfPairs.size <2){
            //Detta ger ingen poäng. Stryka?
        }else {
            scoreSheet[8] = listOfPairs[0+1]

        }
    }

    fun trips(){
        val listOfTrips: MutableList<Int> = mutableListOf()
        if(listOfDice[0].currentValue == listOfDice[1].currentValue){
            if(listOfDice[0].currentValue == listOfDice[2].currentValue){

            }
        }
    }
*/
}
