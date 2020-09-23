package com.example.yatzy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_scoreboard.*

class ScoreboardActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scoreboard)

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


        val scoreboardList = intent.getStringArrayListExtra("scoreboardList")

        when(scoreboardList!!.size){
            4 -> {  p1TextView.text = scoreboardList[0]
                    s1TextView.text = scoreboardList[1]
                    p2TextView.text = scoreboardList[2]
                    s2TextView.text = scoreboardList[3]
                    p3TextView.visibility = View.INVISIBLE
                    s3TextView.visibility = View.INVISIBLE
                    p4TextView.visibility = View.INVISIBLE
                    s4TextView.visibility = View.INVISIBLE
                    p5TextView.visibility = View.INVISIBLE
                    s5TextView.visibility = View.INVISIBLE
                    p6TextView.visibility = View.INVISIBLE
                    s6TextView.visibility = View.INVISIBLE
            }
            6 -> {  p1TextView.text = scoreboardList[0]
                    s1TextView.text = scoreboardList[1]
                    p2TextView.text = scoreboardList[2]
                    s2TextView.text = scoreboardList[3]
                    p3TextView.text = scoreboardList[4]
                    s3TextView.text = scoreboardList[5]
                    p4TextView.visibility = View.INVISIBLE
                    s4TextView.visibility = View.INVISIBLE
                    p5TextView.visibility = View.INVISIBLE
                    s5TextView.visibility = View.INVISIBLE
                    p6TextView.visibility = View.INVISIBLE
                    s6TextView.visibility = View.INVISIBLE
            }
            8 -> {  p1TextView.text = scoreboardList[0]
                    s1TextView.text = scoreboardList[1]
                    p2TextView.text = scoreboardList[2]
                    s2TextView.text = scoreboardList[3]
                    p3TextView.text = scoreboardList[4]
                    s3TextView.text = scoreboardList[5]
                    p4TextView.text = scoreboardList[6]
                    s4TextView.text = scoreboardList[7]
                    p5TextView.visibility = View.INVISIBLE
                    s5TextView.visibility = View.INVISIBLE
                    p6TextView.visibility = View.INVISIBLE
                    s6TextView.visibility = View.INVISIBLE
            }
            10 -> { p1TextView.text = scoreboardList[0]
                    s1TextView.text = scoreboardList[1]
                    p2TextView.text = scoreboardList[2]
                    s2TextView.text = scoreboardList[3]
                    p3TextView.text = scoreboardList[4]
                    s3TextView.text = scoreboardList[5]
                    p4TextView.text = scoreboardList[6]
                    s4TextView.text = scoreboardList[7]
                    p5TextView.text = scoreboardList[8]
                    s5TextView.text = scoreboardList[9]
                    p6TextView.visibility = View.INVISIBLE
                    s6TextView.visibility = View.INVISIBLE
            }
            12 -> { p1TextView.text = scoreboardList[0]
                    s1TextView.text = scoreboardList[1]
                    p2TextView.text = scoreboardList[2]
                    s2TextView.text = scoreboardList[3]
                    p3TextView.text = scoreboardList[4]
                    s3TextView.text = scoreboardList[5]
                    p4TextView.text = scoreboardList[6]
                    s4TextView.text = scoreboardList[7]
                    p5TextView.text = scoreboardList[8]
                    s5TextView.text = scoreboardList[9]
                    p6TextView.text = scoreboardList[10]
                    s6TextView.text = scoreboardList[11]
            }
        }
    }

    fun startAgain(view: View){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

}