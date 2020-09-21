package com.example.yatzy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_scoreboard.*

class ScoreboardActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scoreboard)

        var scoreboardList = intent.getStringArrayListExtra("scoreboardList")

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