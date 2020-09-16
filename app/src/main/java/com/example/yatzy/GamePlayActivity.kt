package com.example.yatzy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class GamePlayActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_play)

        var listOfPlayerNames = intent.getStringArrayListExtra("listOfPlayerNames")
        val listOfPlayers :MutableList<Player> = mutableListOf<Player>()
        if (listOfPlayerNames != null) {
            for(playerName in listOfPlayerNames){
                var newPlayer = Player ("$playerName")
                listOfPlayers.add(newPlayer)
                Log.d("!!!", "$listOfPlayers")
            }
        }
    }


}