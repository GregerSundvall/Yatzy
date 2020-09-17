package com.example.yatzy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class GamePlayActivity : AppCompatActivity() {

    val listOfPlayers :MutableList<Player> = mutableListOf<Player>()
    val listOfDice :MutableList<Die> = mutableListOf<Die>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_play)

        var listOfPlayerNames = intent.getStringArrayListExtra("listOfPlayerNames")

        if (listOfPlayerNames != null) {
            for(playerName in listOfPlayerNames){
                //var newPlayer = Player ("$playerName")
                listOfPlayers.add(Player("$playerName"))
                Log.d("!!!", "$listOfPlayers")
            }
        }

        for(player in listOfPlayers){
            player.scoreSheet.add(Score(1, "Aces"))
        }
        for(player in listOfPlayers){
            player.scoreSheet.add(Score(2, "Twos"))
        }
        for(player in listOfPlayers){
            player.scoreSheet.add(Score(3, "Threes"))
        }
        for(player in listOfPlayers){
            player.scoreSheet.add(Score(4, "Fours"))
        }
        for(player in listOfPlayers){
            player.scoreSheet.add(Score(5, "Fives"))
        }
        for(player in listOfPlayers){
            player.scoreSheet.add(Score(6, "Sixes"))
        }
        for(player in listOfPlayers){
            player.scoreSheet.add(Score(7, "Sum"))
        }
        for(player in listOfPlayers){
            player.scoreSheet.add(Score(8, "Bonus"))
        }
        for(player in listOfPlayers){
            player.scoreSheet.add(Score(9, "Pair"))
        }
        for(player in listOfPlayers){
            player.scoreSheet.add(Score(10, "Two pairs"))
        }
        for(player in listOfPlayers){
            player.scoreSheet.add(Score(11, "3 of a kind"))
        }
        for(player in listOfPlayers){
            player.scoreSheet.add(Score(12, "4 of a kind"))
        }
        for(player in listOfPlayers){
            player.scoreSheet.add(Score(13, "Full house"))
        }
        for(player in listOfPlayers){
            player.scoreSheet.add(Score(14, "SM straight"))
        }
        for(player in listOfPlayers){
            player.scoreSheet.add(Score(15, "LG straight"))
        }
        for(player in listOfPlayers){
            player.scoreSheet.add(Score(16, "Yahtzee"))
        }
        for(player in listOfPlayers){
            player.scoreSheet.add(Score(17, "Total"))
        }

        for(i in 1..5){
            listOfDice.add(Die())
        }
    }

    fun rollAll(){
        for(die in listOfDice){
            if(die.toBeRolled == true)
            die.roll()
        }
    }





}