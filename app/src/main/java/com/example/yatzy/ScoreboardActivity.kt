package com.example.yatzy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_scoreboard.*

class ScoreboardActivity : AppCompatActivity() {

    val listOfPlayers : MutableList <Player> = mutableListOf<Player>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scoreboard)


        name1TextView.text = getString(R.string.player1Name, listOfPlayers[0].name)
        score1TextView.text = getString(R.string.player1Score, listOfPlayers[0].score.toString())

        name2TextView.text = getString(R.string.player2Name, listOfPlayers[1].name)
        score2TextView.text = getString(R.string.player2Score, listOfPlayers[1].score.toString())

    }




}