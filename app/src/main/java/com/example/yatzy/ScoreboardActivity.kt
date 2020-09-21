package com.example.yatzy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ScoreboardActivity : AppCompatActivity() {

    val listOfPlayers : MutableList <Player> = mutableListOf<Player>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scoreboard)
    }




}