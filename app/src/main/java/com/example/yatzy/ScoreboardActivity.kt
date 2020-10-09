package com.example.yatzy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
        val player1NameTextView = findViewById<TextView>(R.id.player1NameTextView)
        val player2NameTextView = findViewById<TextView>(R.id.player2NameTextView)
        val player3NameTextView = findViewById<TextView>(R.id.player3NameTextView)
        val player4NameTextView = findViewById<TextView>(R.id.player4NameTextView)
        val player5NameTextView = findViewById<TextView>(R.id.player5NameTextView)
        val player6NameTextView = findViewById<TextView>(R.id.player6NameTextView)
        val player1ScoreTextView = findViewById<TextView>(R.id.onesP1TextView)
        val player2ScoreTextView = findViewById<TextView>(R.id.player2ScoreTextView)
        val player3ScoreTextView = findViewById<TextView>(R.id.player3ScoreTextView)
        val player4ScoreTextView = findViewById<TextView>(R.id.player4ScoreTextView)
        val player5ScoreTextView = findViewById<TextView>(R.id.player5ScoreTextView)
        val player6ScoreTextView = findViewById<TextView>(R.id.player6ScoreTextView)


        player1NameTextView.text = getString(R.string.playerName,
            ObjectManager.listOfPlayers[0].name)
        player1ScoreTextView.text = getString(R.string.totalScore,
            ObjectManager.listOfPlayers[0].scoreSheet[17].points.toString())

        player2NameTextView.text = getString(R.string.playerName,
            ObjectManager.listOfPlayers[1].name)
        player2ScoreTextView.text = getString(R.string.totalScore,
            ObjectManager.listOfPlayers[1].scoreSheet[17].points.toString())

        player3NameTextView.visibility = View.INVISIBLE
        player4NameTextView.visibility = View.INVISIBLE
        player5NameTextView.visibility = View.INVISIBLE
        player6NameTextView.visibility = View.INVISIBLE
        player3ScoreTextView.visibility = View.INVISIBLE
        player4ScoreTextView.visibility = View.INVISIBLE
        player5ScoreTextView.visibility = View.INVISIBLE
        player6ScoreTextView.visibility = View.INVISIBLE


            if(ObjectManager.listOfPlayers.size >= 3){
            player3NameTextView.text = getString(R.string.playerName,
                ObjectManager.listOfPlayers[2].name)
            player3ScoreTextView.text = getString(R.string.totalScore,
                ObjectManager.listOfPlayers[2].scoreSheet[17].points.toString())

            player3NameTextView.visibility = View.VISIBLE
            player3ScoreTextView.visibility = View.VISIBLE

            if(ObjectManager.listOfPlayers.size >= 4){
                player4NameTextView.text = getString(R.string.playerName,
                    ObjectManager.listOfPlayers[3].name)
                player4ScoreTextView.text = getString(R.string.totalScore,
                    ObjectManager.listOfPlayers[3].scoreSheet[17].points.toString())

                player4NameTextView.visibility = View.VISIBLE
                player4ScoreTextView.visibility = View.VISIBLE

                if(ObjectManager.listOfPlayers.size >= 5){
                    player5NameTextView.text = getString(R.string.playerName,
                        ObjectManager.listOfPlayers[4].name)
                    player5ScoreTextView.text = getString(R.string.totalScore,
                        ObjectManager.listOfPlayers[4].scoreSheet[17].points.toString())

                    player5NameTextView.visibility = View.VISIBLE
                    player5ScoreTextView.visibility = View.VISIBLE

                    if(ObjectManager.listOfPlayers.size == 6){
                        player6NameTextView.text = getString(R.string.playerName,
                            ObjectManager.listOfPlayers[5].name)
                        player6ScoreTextView.text = getString(R.string.totalScore,
                            ObjectManager.listOfPlayers[5].scoreSheet[17].points.toString())

                        player6NameTextView.visibility = View.VISIBLE
                        player6ScoreTextView.visibility = View.VISIBLE
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