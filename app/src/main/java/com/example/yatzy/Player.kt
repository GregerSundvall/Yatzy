package com.example.yatzy

import java.util.*
//object Settings{
    //var listOfPlayers:MutableList<Player> = mutableListOf()
//}

class Player (var name : String,
              var scoreSheet: MutableList<Score> = mutableListOf(),
              var reRolls : Int = 2

){/*

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
*/
}
