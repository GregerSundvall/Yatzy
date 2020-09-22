package com.example.yatzy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_scoreboard.*

class ScoreboardActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scoreboard)

        var p1TextView = findViewById<TextView>(R.id.name1TextView)
        var s1TextView = findViewById<TextView>(R.id.score1TextView)
        var p2TextView = findViewById<TextView>(R.id.name2TextView)
        var s2TextView = findViewById<TextView>(R.id.score2TextView)
        var p3TextView = findViewById<TextView>(R.id.name3TextView)
        var s3TextView = findViewById<TextView>(R.id.score3TextView)
        var p4TextView = findViewById<TextView>(R.id.name4TextView)
        var s4TextView = findViewById<TextView>(R.id.score4TextView)
        var p5TextView = findViewById<TextView>(R.id.name5TextView)
        var s5TextView = findViewById<TextView>(R.id.score5TextView)
        var p6TextView = findViewById<TextView>(R.id.name6TextView)
        var s6TextView = findViewById<TextView>(R.id.score6TextView)


        var scoreboardList = intent.getStringArrayListExtra("scoreboardList")

        when(scoreboardList!!.size){
            4 -> {  p1TextView.text = scoreboardList!![0]
                    s1TextView.text = scoreboardList!![1]
                    p2TextView.text = scoreboardList!![2]
                    s2TextView.text = scoreboardList!![3]
                    p3TextView.visibility = View.INVISIBLE
                    s3TextView.visibility = View.INVISIBLE
                    p4TextView.visibility = View.INVISIBLE
                    s4TextView.visibility = View.INVISIBLE
                    p5TextView.visibility = View.INVISIBLE
                    s5TextView.visibility = View.INVISIBLE
                    p6TextView.visibility = View.INVISIBLE
                    s6TextView.visibility = View.INVISIBLE
            }
            6 -> {  p1TextView.text = scoreboardList!![0]
                    s1TextView.text = scoreboardList!![1]
                    p2TextView.text = scoreboardList!![2]
                    s2TextView.text = scoreboardList!![3]
                    p3TextView.text = scoreboardList!![4]
                    s3TextView.text = scoreboardList!![5]
                    p4TextView.visibility = View.INVISIBLE
                    s4TextView.visibility = View.INVISIBLE
                    p5TextView.visibility = View.INVISIBLE
                    s5TextView.visibility = View.INVISIBLE
                    p6TextView.visibility = View.INVISIBLE
                    s6TextView.visibility = View.INVISIBLE
            }
            8 -> {  p1TextView.text = scoreboardList!![0]
                    s1TextView.text = scoreboardList!![1]
                    p2TextView.text = scoreboardList!![2]
                    s2TextView.text = scoreboardList!![3]
                    p3TextView.text = scoreboardList!![4]
                    s3TextView.text = scoreboardList!![5]
                    p4TextView.text = scoreboardList!![6]
                    s4TextView.text = scoreboardList!![7]
                    p5TextView.visibility = View.INVISIBLE
                    s5TextView.visibility = View.INVISIBLE
                    p6TextView.visibility = View.INVISIBLE
                    s6TextView.visibility = View.INVISIBLE
            }
            10 -> { p1TextView.text = scoreboardList!![0]
                    s1TextView.text = scoreboardList!![1]
                    p2TextView.text = scoreboardList!![2]
                    s2TextView.text = scoreboardList!![3]
                    p3TextView.text = scoreboardList!![4]
                    s3TextView.text = scoreboardList!![5]
                    p4TextView.text = scoreboardList!![6]
                    s4TextView.text = scoreboardList!![7]
                    p5TextView.text = scoreboardList!![8]
                    s5TextView.text = scoreboardList!![9]
                    p6TextView.visibility = View.INVISIBLE
                    s6TextView.visibility = View.INVISIBLE
            }
            12 -> { p1TextView.text = scoreboardList!![0]
                    s1TextView.text = scoreboardList!![1]
                    p2TextView.text = scoreboardList!![2]
                    s2TextView.text = scoreboardList!![3]
                    p3TextView.text = scoreboardList!![4]
                    s3TextView.text = scoreboardList!![5]
                    p4TextView.text = scoreboardList!![6]
                    s4TextView.text = scoreboardList!![7]
                    p5TextView.text = scoreboardList!![8]
                    s5TextView.text = scoreboardList!![9]
                    p6TextView.text = scoreboardList!![10]
                    s6TextView.text = scoreboardList!![11]
            }
        }

        val p1Name = scoreboardList!![0]
        val p1Score = scoreboardList!![1]
        val p2Name = scoreboardList!![2]
        val p2Score = scoreboardList!![3]

        name1TextView.text = getString(R.string.player1Name, p1Name)
        score1TextView.text = getString(R.string.player1Score, p1Score)

        name2TextView.text = getString(R.string.player2Name, p2Name)
        score2TextView.text = getString(R.string.player2Score, p2Score)

    }
/*
    fun setScoreboard(){
        val p1name = scor[
        val p1score :String = listOfPlayers[0].score.toString()

        val p2name = listOfPlayers[1].name
        val p2score :String = listOfPlayers[1].score.toString()

    }
*/


}