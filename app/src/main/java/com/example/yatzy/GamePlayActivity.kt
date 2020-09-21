package com.example.yatzy

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_game_play.*

class GamePlayActivity : AppCompatActivity() {

    val listOfPlayers: MutableList<Player> = mutableListOf<Player>()
    //val listOfDice: MutableList<Die> = mutableListOf<Die>()
    val listOfDieImageViews: MutableList<ImageView> = mutableListOf<ImageView>()
    var nrOfPlayers : Int = 0
    var roundNumber : Int = 0
    lateinit var currentPlayer :Player
    lateinit var nameTextView : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_play)

        //Adds received list of player names to players list
        var listOfPlayerNames = intent.getStringArrayListExtra("listOfPlayerNames")
        if (listOfPlayerNames != null) {
            for (playerName in listOfPlayerNames) {
                listOfPlayers.add(Player("$playerName"))
            }
        }
        //Sets up a scoresheet for each player
        for (player in listOfPlayers) {
            player.scoreSheet.add(Score(1, "Aces"))
        }
        for (player in listOfPlayers) {
            player.scoreSheet.add(Score(2, "Twos"))
        }
        for (player in listOfPlayers) {
            player.scoreSheet.add(Score(3, "Threes"))
        }
        for (player in listOfPlayers) {
            player.scoreSheet.add(Score(4, "Fours"))
        }
        for (player in listOfPlayers) {
            player.scoreSheet.add(Score(5, "Fives"))
        }
        for (player in listOfPlayers) {
            player.scoreSheet.add(Score(6, "Sixes"))
        }
        for (player in listOfPlayers) {
            player.scoreSheet.add(Score(7, "Sum"))
        }
        for (player in listOfPlayers) {
            player.scoreSheet.add(Score(8, "Bonus"))
        }
        for (player in listOfPlayers) {
            player.scoreSheet.add(Score(9, "Pair"))
        }
        for (player in listOfPlayers) {
            player.scoreSheet.add(Score(10, "Two pairs"))
        }
        for (player in listOfPlayers) {
            player.scoreSheet.add(Score(11, "3 of a kind"))
        }
        for (player in listOfPlayers) {
            player.scoreSheet.add(Score(12, "4 of a kind"))
        }
        for (player in listOfPlayers) {
            player.scoreSheet.add(Score(13, "Full house"))
        }
        for (player in listOfPlayers) {
            player.scoreSheet.add(Score(14, "SM straight"))
        }
        for (player in listOfPlayers) {
            player.scoreSheet.add(Score(15, "LG straight"))
        }
        for (player in listOfPlayers) {
            player.scoreSheet.add(Score(16, "Yahtzee"))
        }
        for (player in listOfPlayers) {
            player.scoreSheet.add(Score(17, "Total"))
        }
        //Creates and adds a set of dice for each player
        for(player in listOfPlayers) {
            for (i in 1..5) {
                player.listOfDice.add(Die())
            }
        }
        //adds die imageviews to list
        listOfDieImageViews.add(findViewById(R.id.die1))
        listOfDieImageViews.add(findViewById(R.id.die2))
        listOfDieImageViews.add(findViewById(R.id.die3))
        listOfDieImageViews.add(findViewById(R.id.die4))
        listOfDieImageViews.add(findViewById(R.id.die5))

        currentPlayer = listOfPlayers[0]
        nameTextView = findViewById(R.id.whoIsPlayingTextView)

        startRound()

    }

    fun startRound(){
        nameTextView.text = getString(R.string.name_is_playing, currentPlayer.name)
        rollAll()
    }

    fun saveOnes(view: View){
        currentPlayer.setOnes()
        //view.visibility = View.INVISIBLE
        nextPlayer()
        newRoundOrScoreboard()
    }

    fun newRoundOrScoreboard(){
        if(roundNumber < 1){
            startRound()
        }else{
            startScoreboardActivity()
        }
    }

    fun startScoreboardActivity()   {
        var scoreboardList :ArrayList<String> = arrayListOf()
        for(player in listOfPlayers){
            scoreboardList.add(player.name)
            scoreboardList.add(player.score.toString())
        }
        val intent = Intent(this, ScoreboardActivity::class.java)
        intent.putStringArrayListExtra("scoreboardList", scoreboardList)
        startActivity(intent)

    }

    fun nextPlayer(){
        if(currentPlayer == listOfPlayers.last()){
            currentPlayer = listOfPlayers[0]
            roundNumber += 1
        }else {
            currentPlayer = listOfPlayers[+1]
        }
    }

    //Rolls all dice and sets them not to be rolled
    fun rollAll(){
        for(die in currentPlayer.listOfDice){
            die.currentValue =  (1..6).random()
            die.toBeRolled = false

        }
        setDiceImages()
    }
        //Rolls dice selected for re-roll
    fun reRoll(view: View){
        if(currentPlayer!!.reRolls > 0){
            for(die in currentPlayer.listOfDice) {
                if (die.toBeRolled == true) {
                    die.currentValue =  (1..6).random()
                    die.toBeRolled = false
                }
            }
            currentPlayer.reRolls -= 1
        }
        setDiceImages()
    }



        //Sets correct die images according to values
    fun setDieImage(die : Die, dieView: ImageView){
            when(die.currentValue){
            1 -> dieView.setImageResource(R.drawable.die1)
            2 -> dieView.setImageResource(R.drawable.die2)
            3 -> dieView.setImageResource(R.drawable.die3)
            4 -> dieView.setImageResource(R.drawable.die4)
            5 -> dieView.setImageResource(R.drawable.die5)
            6 -> dieView.setImageResource(R.drawable.die6)
        }
    }

    fun setDiceImages(){
        setDieImage(currentPlayer.listOfDice[0], listOfDieImageViews[0])
        setDieImage(currentPlayer.listOfDice[1], listOfDieImageViews[1])
        setDieImage(currentPlayer.listOfDice[2], listOfDieImageViews[2])
        setDieImage(currentPlayer.listOfDice[3], listOfDieImageViews[3])
        setDieImage(currentPlayer.listOfDice[4], listOfDieImageViews[4])
    }

    fun selectDie1(view: View){
        when(currentPlayer.listOfDice[0].toBeRolled) {
            false -> {when (currentPlayer.listOfDice[0].currentValue) {
                1 -> listOfDieImageViews[0].setImageResource(R.drawable.die1selected)
                2 -> listOfDieImageViews[0].setImageResource(R.drawable.die2selected)
                3 -> listOfDieImageViews[0].setImageResource(R.drawable.die3selected)
                4 -> listOfDieImageViews[0].setImageResource(R.drawable.die4selected)
                5 -> listOfDieImageViews[0].setImageResource(R.drawable.die5selected)
                6 -> listOfDieImageViews[0].setImageResource(R.drawable.die6selected)
            }
                currentPlayer.listOfDice [0].toBeRolled = true}

            true -> {when (currentPlayer.listOfDice[0].currentValue) {
                1 -> listOfDieImageViews[0].setImageResource(R.drawable.die1)
                2 -> listOfDieImageViews[0].setImageResource(R.drawable.die2)
                3 -> listOfDieImageViews[0].setImageResource(R.drawable.die3)
                4 -> listOfDieImageViews[0].setImageResource(R.drawable.die4)
                5 -> listOfDieImageViews[0].setImageResource(R.drawable.die5)
                6 -> listOfDieImageViews[0].setImageResource(R.drawable.die6)
            }
                currentPlayer.listOfDice [0].toBeRolled = false}
        }
    }

    fun selectDie2(view: View){
        when(currentPlayer.listOfDice[1].toBeRolled) {
            false -> {when (currentPlayer.listOfDice[1].currentValue) {
                1 -> listOfDieImageViews[1].setImageResource(R.drawable.die1selected)
                2 -> listOfDieImageViews[1].setImageResource(R.drawable.die2selected)
                3 -> listOfDieImageViews[1].setImageResource(R.drawable.die3selected)
                4 -> listOfDieImageViews[1].setImageResource(R.drawable.die4selected)
                5 -> listOfDieImageViews[1].setImageResource(R.drawable.die5selected)
                6 -> listOfDieImageViews[1].setImageResource(R.drawable.die6selected)
            }
                currentPlayer.listOfDice [1].toBeRolled = true}

            true -> {when (currentPlayer.listOfDice[1].currentValue) {
                1 -> listOfDieImageViews[1].setImageResource(R.drawable.die1)
                2 -> listOfDieImageViews[1].setImageResource(R.drawable.die2)
                3 -> listOfDieImageViews[1].setImageResource(R.drawable.die3)
                4 -> listOfDieImageViews[1].setImageResource(R.drawable.die4)
                5 -> listOfDieImageViews[1].setImageResource(R.drawable.die5)
                6 -> listOfDieImageViews[1].setImageResource(R.drawable.die6)
            }
                currentPlayer.listOfDice [1].toBeRolled = false}
        }
    }

    fun selectDie3(view: View){
        when(currentPlayer.listOfDice[2].toBeRolled) {
            false -> {when (currentPlayer.listOfDice[2].currentValue) {
                1 -> listOfDieImageViews[2].setImageResource(R.drawable.die1selected)
                2 -> listOfDieImageViews[2].setImageResource(R.drawable.die2selected)
                3 -> listOfDieImageViews[2].setImageResource(R.drawable.die3selected)
                4 -> listOfDieImageViews[2].setImageResource(R.drawable.die4selected)
                5 -> listOfDieImageViews[2].setImageResource(R.drawable.die5selected)
                6 -> listOfDieImageViews[2].setImageResource(R.drawable.die6selected)
            }
                currentPlayer.listOfDice [2].toBeRolled = true}

            true -> {when (currentPlayer.listOfDice[2].currentValue) {
                1 -> listOfDieImageViews[2].setImageResource(R.drawable.die1)
                2 -> listOfDieImageViews[2].setImageResource(R.drawable.die2)
                3 -> listOfDieImageViews[2].setImageResource(R.drawable.die3)
                4 -> listOfDieImageViews[2].setImageResource(R.drawable.die4)
                5 -> listOfDieImageViews[2].setImageResource(R.drawable.die5)
                6 -> listOfDieImageViews[2].setImageResource(R.drawable.die6)
            }
                currentPlayer.listOfDice [2].toBeRolled = false}
        }
    }


    fun selectDie4(view: View){
        when(currentPlayer.listOfDice[3].toBeRolled) {
            false -> {when (currentPlayer.listOfDice[3].currentValue) {
                1 -> listOfDieImageViews[3].setImageResource(R.drawable.die1selected)
                2 -> listOfDieImageViews[3].setImageResource(R.drawable.die2selected)
                3 -> listOfDieImageViews[3].setImageResource(R.drawable.die3selected)
                4 -> listOfDieImageViews[3].setImageResource(R.drawable.die4selected)
                5 -> listOfDieImageViews[3].setImageResource(R.drawable.die5selected)
                6 -> listOfDieImageViews[3].setImageResource(R.drawable.die6selected)
            }
                currentPlayer.listOfDice [3].toBeRolled = true}

            true -> {when (currentPlayer.listOfDice[3].currentValue) {
                1 -> listOfDieImageViews[3].setImageResource(R.drawable.die1)
                2 -> listOfDieImageViews[3].setImageResource(R.drawable.die2)
                3 -> listOfDieImageViews[3].setImageResource(R.drawable.die3)
                4 -> listOfDieImageViews[3].setImageResource(R.drawable.die4)
                5 -> listOfDieImageViews[3].setImageResource(R.drawable.die5)
                6 -> listOfDieImageViews[3].setImageResource(R.drawable.die6)
            }
                currentPlayer.listOfDice [3].toBeRolled = false}
        }
    }

    fun selectDie5(view: View){
        when(currentPlayer.listOfDice[4].toBeRolled) {
            false -> {when (currentPlayer.listOfDice[4].currentValue) {
                1 -> listOfDieImageViews[4].setImageResource(R.drawable.die1selected)
                2 -> listOfDieImageViews[4].setImageResource(R.drawable.die2selected)
                3 -> listOfDieImageViews[4].setImageResource(R.drawable.die3selected)
                4 -> listOfDieImageViews[4].setImageResource(R.drawable.die4selected)
                5 -> listOfDieImageViews[4].setImageResource(R.drawable.die5selected)
                6 -> listOfDieImageViews[4].setImageResource(R.drawable.die6selected)
            }
                currentPlayer.listOfDice [4].toBeRolled = true}

            true -> {when (currentPlayer.listOfDice[4].currentValue) {
                1 -> listOfDieImageViews[4].setImageResource(R.drawable.die1)
                2 -> listOfDieImageViews[4].setImageResource(R.drawable.die2)
                3 -> listOfDieImageViews[4].setImageResource(R.drawable.die3)
                4 -> listOfDieImageViews[4].setImageResource(R.drawable.die4)
                5 -> listOfDieImageViews[4].setImageResource(R.drawable.die5)
                6 -> listOfDieImageViews[4].setImageResource(R.drawable.die6)
            }
                currentPlayer.listOfDice [4].toBeRolled = false}
        }
    }



}