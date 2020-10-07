package com.example.yatzy


class Player (var name : String,
              var scoreSheet: MutableList<Score> = mutableListOf(),
              var rolls : Int = 3,
              var listOfDice: MutableList<Die> = mutableListOf(),
              var alreadySaved : Boolean = false

)
