package com.example.yatzy

class Die (var currentValue: Int = (1..6).random()
){
    fun rollDie(){
        currentValue =  (1..6).random()
    }
}
