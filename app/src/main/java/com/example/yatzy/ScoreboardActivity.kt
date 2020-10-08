package com.example.yatzy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView

class ScoreboardActivity : AppCompatActivity() {

    val listOfPlayers = ObjectManager.listOfPlayers

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scoreboard)
        summarizePoints()
        showScores()
    }

    //Summarizes every player's bonus and score
    fun summarizePoints(){
        for(player in ObjectManager.listOfPlayers){
            player.scoreSheet[15].saveScore(player)
            player.scoreSheet[16].saveScore(player)
            player.scoreSheet[17].saveScore(player)
        }
    }

        //Shows necessary fields and info
    fun showScores(){
        val player1TextView = findViewById<TextView>(R.id.player1TextView)
        val player2TextView = findViewById<TextView>(R.id.player2TextView)
        val player3TextView = findViewById<TextView>(R.id.player3TextView)
        val player4TextView = findViewById<TextView>(R.id.player4TextView)
        val player5TextView = findViewById<TextView>(R.id.player5TextView)
        val player6TextView = findViewById<TextView>(R.id.player6TextView)

        player1TextView.text = getString(R.string.playerNameAndScore,
            ObjectManager.listOfPlayers[0].name,
            ObjectManager.listOfPlayers[0].scoreSheet[17].points.toString())
        player2TextView.text = getString(R.string.playerNameAndScore,
            ObjectManager.listOfPlayers[1].name,
            ObjectManager.listOfPlayers[1].scoreSheet[17].points.toString())
        player3TextView.visibility = View.INVISIBLE
        player4TextView.visibility = View.INVISIBLE
        player5TextView.visibility = View.INVISIBLE
        player6TextView.visibility = View.INVISIBLE

        if(ObjectManager.listOfPlayers.size >= 3){
            player3TextView.text = getString(R.string.playerNameAndScore,
                ObjectManager.listOfPlayers[2].name,
                ObjectManager.listOfPlayers[2].scoreSheet[17].points.toString())
            player3TextView.visibility = View.VISIBLE
            if(ObjectManager.listOfPlayers.size >= 4){
                player4TextView.text = getString(R.string.playerNameAndScore,
                    ObjectManager.listOfPlayers[3].name,
                    ObjectManager.listOfPlayers[3].scoreSheet[17].points.toString())
                player4TextView.visibility = View.VISIBLE
                if(ObjectManager.listOfPlayers.size >= 5){
                    player5TextView.text = getString(R.string.playerNameAndScore,
                        ObjectManager.listOfPlayers[4].name,
                        ObjectManager.listOfPlayers[4].scoreSheet[17].points.toString())
                    player5TextView.visibility = View.VISIBLE
                    if(ObjectManager.listOfPlayers.size == 6){
                        player6TextView.text = getString(R.string.playerNameAndScore,
                            ObjectManager.listOfPlayers[5].name,
                            ObjectManager.listOfPlayers[5].scoreSheet[17].points.toString())
                        player6TextView.visibility = View.VISIBLE
                    }
                }
            }
        }
    }
        //Clears list of players and restarts game
    fun playAgain(view: View){
            ObjectManager.listOfPlayers.clear()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}