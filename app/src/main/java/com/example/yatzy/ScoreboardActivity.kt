package com.example.yatzy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_scoreboard.*

class ScoreboardActivity : AppCompatActivity() {

    val listOfPlayers = Players.listOfPlayers

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scoreboard)

        showScores()
    }

        //Shows necessary fields and writes out info
    fun showScores(){
        val p1NameTextView = findViewById<TextView>(R.id.name1TextView)
        val p1ScoreTextView = findViewById<TextView>(R.id.score1TextView)
        val p2NameTextView = findViewById<TextView>(R.id.name2TextView)
        val p2ScoreTextView = findViewById<TextView>(R.id.score2TextView)
        val p3NameTextView = findViewById<TextView>(R.id.name3TextView)
        val p3ScoreTextView = findViewById<TextView>(R.id.score3TextView)
        val p4NameTextView = findViewById<TextView>(R.id.name4TextView)
        val p4ScoreTextView = findViewById<TextView>(R.id.score4TextView)
        val p5NameTextView = findViewById<TextView>(R.id.name5TextView)
        val p5ScoreTextView = findViewById<TextView>(R.id.score5TextView)
        val p6NameTextView = findViewById<TextView>(R.id.name6TextView)
        val p6ScoreTextView = findViewById<TextView>(R.id.score6TextView)

        p1NameTextView.text = listOfPlayers[0].name
        p1ScoreTextView.text = listOfPlayers[0].scoreSheet[17].points.toString()
        p2NameTextView.text = listOfPlayers[1].name
        p2ScoreTextView.text = listOfPlayers[1].scoreSheet[17].points.toString()
        p3NameTextView.visibility = View.INVISIBLE
        p3ScoreTextView.visibility = View.INVISIBLE
        p4NameTextView.visibility = View.INVISIBLE
        p4ScoreTextView.visibility = View.INVISIBLE
        p5NameTextView.visibility = View.INVISIBLE
        p5ScoreTextView.visibility = View.INVISIBLE
        p6NameTextView.visibility = View.INVISIBLE
        p6ScoreTextView.visibility = View.INVISIBLE


        if(listOfPlayers.size >= 3){
            p3NameTextView.text = listOfPlayers[2].name
            p3ScoreTextView.text = listOfPlayers[2].scoreSheet[17].points.toString()
            p3NameTextView.visibility = View.VISIBLE
            p3ScoreTextView.visibility = View.VISIBLE
            if(listOfPlayers.size >= 4){
                p4NameTextView.visibility = View.VISIBLE
                p4ScoreTextView.visibility = View.VISIBLE
                p4NameTextView.text = listOfPlayers[3].name
                p4ScoreTextView.text = listOfPlayers[3].scoreSheet[17].points.toString()
                if(listOfPlayers.size >= 5){
                    p5NameTextView.visibility = View.VISIBLE
                    p5ScoreTextView.visibility = View.VISIBLE
                    p5NameTextView.text = listOfPlayers[4].name
                    p5ScoreTextView.text = listOfPlayers[4].scoreSheet[17].points.toString()
                    if(listOfPlayers.size == 6){
                        p6NameTextView.visibility = View.VISIBLE
                        p6ScoreTextView.visibility = View.VISIBLE
                        p6NameTextView.text = listOfPlayers[5].name
                        p6ScoreTextView.text = listOfPlayers[5].scoreSheet[17].points.toString()
                    }
                }
            }
        }
    }

    fun playAgain(view: View){
        listOfPlayers.clear()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}