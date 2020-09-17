package com.example.yatzy

class Die (var currentValue: Int = (1..6).random(),
           var toBeRolled: Boolean = true
){
    fun roll(){
        currentValue =  (1..6).random()
    }
}
