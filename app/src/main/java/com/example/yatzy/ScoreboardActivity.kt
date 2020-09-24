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

        //writes out names and scores on screen
    fun showScores(){
        val p1TextView = findViewById<TextView>(R.id.name1TextView)
        val s1TextView = findViewById<TextView>(R.id.score1TextView)
        val p2TextView = findViewById<TextView>(R.id.name2TextView)
        val s2TextView = findViewById<TextView>(R.id.score2TextView)
        val p3TextView = findViewById<TextView>(R.id.name3TextView)
        val s3TextView = findViewById<TextView>(R.id.score3TextView)
        val p4TextView = findViewById<TextView>(R.id.name4TextView)
        val s4TextView = findViewById<TextView>(R.id.score4TextView)
        val p5TextView = findViewById<TextView>(R.id.name5TextView)
        val s5TextView = findViewById<TextView>(R.id.score5TextView)
        val p6TextView = findViewById<TextView>(R.id.name6TextView)
        val s6TextView = findViewById<TextView>(R.id.score6TextView)

        when(listOfPlayers.size){
            2 -> {  p1TextView.text = listOfPlayers[0].name
                    s1TextView.text = listOfPlayers[0].scoreSheet[17].points.toString()
                    p2TextView.text = listOfPlayers[1].name
                    s2TextView.text = listOfPlayers[1].scoreSheet[17].points.toString()
                    p3TextView.visibility = View.INVISIBLE
                    s3TextView.visibility = View.INVISIBLE
                    p4TextView.visibility = View.INVISIBLE
                    s4TextView.visibility = View.INVISIBLE
                    p5TextView.visibility = View.INVISIBLE
                    s5TextView.visibility = View.INVISIBLE
                    p6TextView.visibility = View.INVISIBLE
                    s6TextView.visibility = View.INVISIBLE
            }
            3 -> {  p1TextView.text = listOfPlayers[0].name
                    s1TextView.text = listOfPlayers[0].scoreSheet[17].points.toString()
                    p2TextView.text = listOfPlayers[1].name
                    s2TextView.text = listOfPlayers[1].scoreSheet[17].points.toString()
                    p3TextView.text = listOfPlayers[2].name
                    s3TextView.text = listOfPlayers[2].scoreSheet[17].points.toString()
                    p4TextView.visibility = View.INVISIBLE
                    s4TextView.visibility = View.INVISIBLE
                    p5TextView.visibility = View.INVISIBLE
                    s5TextView.visibility = View.INVISIBLE
                    p6TextView.visibility = View.INVISIBLE
                    s6TextView.visibility = View.INVISIBLE
            }
            4 -> {  p1TextView.text = listOfPlayers[0].name
                    s1TextView.text = listOfPlayers[0].scoreSheet[17].points.toString()
                    p2TextView.text = listOfPlayers[1].name
                    s2TextView.text = listOfPlayers[1].scoreSheet[17].points.toString()
                    p3TextView.text = listOfPlayers[2].name
                    s3TextView.text = listOfPlayers[2].scoreSheet[17].points.toString()
                    p4TextView.text = listOfPlayers[3].name
                    s4TextView.text = listOfPlayers[3].scoreSheet[17].points.toString()
                    p5TextView.visibility = View.INVISIBLE
                    s5TextView.visibility = View.INVISIBLE
                    p6TextView.visibility = View.INVISIBLE
                    s6TextView.visibility = View.INVISIBLE
            }
            5 -> { p1TextView.text = listOfPlayers[0].name
                    s1TextView.text = listOfPlayers[0].scoreSheet[17].points.toString()
                    p2TextView.text = listOfPlayers[1].name
                    s2TextView.text = listOfPlayers[1].scoreSheet[17].points.toString()
                    p3TextView.text = listOfPlayers[2].name
                    s3TextView.text = listOfPlayers[2].scoreSheet[17].points.toString()
                    p4TextView.text = listOfPlayers[3].name
                    s4TextView.text = listOfPlayers[3].scoreSheet[17].points.toString()
                    p5TextView.text = listOfPlayers[4].name
                    s5TextView.text = listOfPlayers[4].scoreSheet[17].points.toString()
                    p6TextView.visibility = View.INVISIBLE
                    s6TextView.visibility = View.INVISIBLE
            }
            6 -> { p1TextView.text = listOfPlayers[0].name
                    s1TextView.text = listOfPlayers[0].scoreSheet[17].points.toString()
                    p2TextView.text = listOfPlayers[1].name
                    s2TextView.text = listOfPlayers[1].scoreSheet[17].points.toString()
                    p3TextView.text = listOfPlayers[2].name
                    s3TextView.text = listOfPlayers[2].scoreSheet[17].points.toString()
                    p4TextView.text = listOfPlayers[3].name
                    s4TextView.text = listOfPlayers[3].scoreSheet[17].points.toString()
                    p5TextView.text = listOfPlayers[4].name
                    s5TextView.text = listOfPlayers[4].scoreSheet[17].points.toString()
                    p6TextView.text = listOfPlayers[5].name
                    s6TextView.text = listOfPlayers[5].scoreSheet[17].points.toString()
            }
        }
    }

    fun playAgain(view: View){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

}