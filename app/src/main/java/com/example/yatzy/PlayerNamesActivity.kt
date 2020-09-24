package com.example.yatzy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_player_names.*

class PlayerNamesActivity : AppCompatActivity() {

    var nrOfplayers = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player_names)

        nrOfplayers = intent.getIntExtra("nrOfPlayers", 2)

        when(nrOfplayers){
            2 ->    {Player3NamePlainText.visibility = View.GONE
                    Player4NamePlainText.visibility = View.GONE
                    Player5NamePlainText.visibility = View.GONE
                    Player6NamePlainText.visibility = View.GONE
            }

            3 ->    {Player4NamePlainText.visibility = View.GONE
                    Player5NamePlainText.visibility = View.GONE
                    Player6NamePlainText.visibility = View.GONE
            }

            4 ->    {Player5NamePlainText.visibility = View.GONE
                    Player6NamePlainText.visibility = View.GONE
            }

            5 ->    {Player6NamePlainText.visibility = View.GONE
            }
        }
    }

        //Creates players from name input
    fun startGamePlayActivity(v : View){
        Players.listOfPlayers.add(Player("${Player1NamePlainText.text}"))
        Players.listOfPlayers.add(Player("${Player2NamePlainText.text}"))

        if (nrOfplayers >= 3) {
            Players.listOfPlayers.add(Player("${Player3NamePlainText.text}"))

            if(nrOfplayers >= 4){
                Players.listOfPlayers.add(Player("${Player4NamePlainText.text}"))

                if(nrOfplayers >= 5){
                    Players.listOfPlayers.add(Player("${Player5NamePlainText.text}"))

                    if(nrOfplayers == 6){
                        Players.listOfPlayers.add(Player("${Player6NamePlainText.text}"))
                    }
                }
            }

        }

        val intent = Intent(this, GamePlayActivity::class.java)
        startActivity(intent)
    }
}