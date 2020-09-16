package com.example.yatzy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class GamePlayActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_play)

        val listOfPlayerNames = intent.getStringArrayListExtra("listOfPlayerNames")

    }
}