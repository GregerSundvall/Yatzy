package com.example.yatzy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_player_names.*

class PlayerNamesActivity : AppCompatActivity() {

    var nrOfplayers = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player_names)

        nrOfplayers = intent.getIntExtra("nrOfPlayers", 2)
        hideUnnecessaryNameboxes()
    }

        //Makes unnecessary nameboxes disappear
    fun hideUnnecessaryNameboxes(){
        if(nrOfplayers <= 5){
            Player6NamePlainText.visibility = View.GONE
            if(nrOfplayers <= 4){
                Player5NamePlainText.visibility = View.GONE
                if(nrOfplayers <= 3){
                    Player4NamePlainText.visibility = View.GONE
                    if(nrOfplayers <= 2){
                        Player3NamePlainText.visibility = View.GONE
                    }
                }
            }
        }
    }

    fun createPlayers(){
        ObjectManager.listOfPlayers.add(Player("${Player1NamePlainText.text}"))
        ObjectManager.listOfPlayers.add(Player("${Player2NamePlainText.text}"))

        if (nrOfplayers >= 3) {
            ObjectManager.listOfPlayers.add(Player("${Player3NamePlainText.text}"))

            if(nrOfplayers >= 4){
                ObjectManager.listOfPlayers.add(Player("${Player4NamePlainText.text}"))

                if(nrOfplayers >= 5){
                    ObjectManager.listOfPlayers.add(Player("${Player5NamePlainText.text}"))

                    if(nrOfplayers == 6){
                        ObjectManager.listOfPlayers.add(Player("${Player6NamePlainText.text}"))
                    }
                }
            }

        }
    }

    fun startGamePlayActivity(v : View){
        createPlayers()
        ObjectManager.currentPlayer = ObjectManager.listOfPlayers.first()
        val intent = Intent(this, GamePlayActivity::class.java)
        startActivity(intent)
    }
}