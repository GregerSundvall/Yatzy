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

        showScores()
    }

        //Shows necessary fields and info
    fun showScores(){
        val p1TextView = findViewById<TextView>(R.id.player1TextView)
        val p2TextView = findViewById<TextView>(R.id.player2TextView)
        val p3TextView = findViewById<TextView>(R.id.player3TextView)
        val p4TextView = findViewById<TextView>(R.id.player4TextView)
        val p5TextView = findViewById<TextView>(R.id.player5TextView)
        val p6TextView = findViewById<TextView>(R.id.player6TextView)

        p1TextView.text = getString(R.string.player1NameAndScore,
            listOfPlayers[0].name, listOfPlayers[0].scoreSheet[17].toString())
        p2TextView.text = getString(R.string.player2NameAndScore,
            listOfPlayers[0].name, listOfPlayers[0].scoreSheet[17].toString())
        p3TextView.visibility = View.INVISIBLE
        p4TextView.visibility = View.INVISIBLE
        p5TextView.visibility = View.INVISIBLE
        p6TextView.visibility = View.INVISIBLE

        if(listOfPlayers.size >= 3){
            p3TextView.text = getString(R.string.player3NameAndScore,
                listOfPlayers[2].name, listOfPlayers[2].scoreSheet[17].toString())
            p3TextView.visibility = View.VISIBLE
            if(listOfPlayers.size >= 4){
                p4TextView.text = getString(R.string.player4NameAndScore,
                    listOfPlayers[3].name, listOfPlayers[3].scoreSheet[17].toString())
                p4TextView.visibility = View.VISIBLE
                if(listOfPlayers.size >= 5){
                    p5TextView.text = getString(R.string.player5NameAndScore,
                        listOfPlayers[4].name, listOfPlayers[4].scoreSheet[17].toString())
                    p5TextView.visibility = View.VISIBLE
                    if(listOfPlayers.size == 6){
                        p6TextView.text = getString(R.string.player6NameAndScore,
                            listOfPlayers[5].name, listOfPlayers[5].scoreSheet[17].toString())
                        p6TextView.visibility = View.VISIBLE
                    }
                }
            }
        }
    }
        //Clears list of players and restarts game
    fun playAgain(view: View){
        listOfPlayers.clear()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}