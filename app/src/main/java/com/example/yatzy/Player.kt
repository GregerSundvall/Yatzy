package com.example.yatzy

import java.util.*
//object Settings{
    //var listOfPlayers:MutableList<Player> = mutableListOf()
//}

class Player (val name : String,
              val scoreSheet: MutableList<Int> = mutableListOf(),
              var listOfPlayers: MutableList<Player> = mutableListOf(),
              val listOfDice : MutableList<Die> = mutableListOf()
){
    fun addDice() {
        for (i in 1..5) {
            listOfDice.add(Die())
        }
    }

    fun rollAll(){
        for (die in listOfDice){
            die.rollDie()
        }
    }

    fun setupScoreSheet(){
        //for(score in 1..18){
        //    scoreSheet.add(0)
        //}
        scoreSheet[6] = scoreSheet[0+1+2+3+4+5]

        if(scoreSheet[6] >= 63){
            scoreSheet[7] = 50
        }

        if(scoreSheet[16] > 0) {
            scoreSheet[16] = 50
        }

        scoreSheet[17] = scoreSheet[7+8+9+10+11+12+13+14+15+16+17]
    }

    fun setOnes() {
        //Ettor
        for (die in listOfDice) {
            if (die.currentValue == 1) {
                scoreSheet[1] += 1
            }
        }
        if(scoreSheet[1].toString().toInt() < 1){
            //return Detta ger inga poäng, vill du stryka denna ruta? Typ..
            //Stryka = nolla poängen i den rutan?
        }
    }
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

}
