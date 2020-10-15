package com.example.yatzy

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class ScoreboardActivity : AppCompatActivity() {

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


        //Displays necessary fields and info
    fun showScores(){
            //Displays player 1 data
        val p1 = ObjectManager.listOfPlayers[0]
        findViewById<TextView>(R.id.nameP1TextView).text = p1.name
        findViewById<TextView>(R.id.onesP1TextView).text = p1.scoreSheet[0].points.toString()
        findViewById<TextView>(R.id.twosP1TextView).text = p1.scoreSheet[1].points.toString()
        findViewById<TextView>(R.id.threesP1TextView).text = p1.scoreSheet[2].points.toString()
        findViewById<TextView>(R.id.foursP1TextView).text = p1.scoreSheet[3].points.toString()
        findViewById<TextView>(R.id.fivesP1TextView).text = p1.scoreSheet[4].points.toString()
        findViewById<TextView>(R.id.sixesP1TextView).text = p1.scoreSheet[5].points.toString()
        findViewById<TextView>(R.id.sumP1TextView).text = p1.scoreSheet[15].points.toString()
        findViewById<TextView>(R.id.bonusP1TextView).text = p1.scoreSheet[16].points.toString()
        findViewById<TextView>(R.id.onePairP1TextView).text = p1.scoreSheet[6].points.toString()
        findViewById<TextView>(R.id.twoPairsP1TextView).text = p1.scoreSheet[7].points.toString()
        findViewById<TextView>(R.id.toakP1TextView).text = p1.scoreSheet[8].points.toString()
        findViewById<TextView>(R.id.foakP1TextView).text = p1.scoreSheet[9].points.toString()
        findViewById<TextView>(R.id.fullHouseP1TextView).text = p1.scoreSheet[10].points.toString()
        findViewById<TextView>(R.id.smStraightP1TextView).text = p1.scoreSheet[11].points.toString()
        findViewById<TextView>(R.id.lgStraightP1TextView).text = p1.scoreSheet[12].points.toString()
        findViewById<TextView>(R.id.chanceP1TextView).text = p1.scoreSheet[13].points.toString()
        findViewById<TextView>(R.id.yatzyP1TextView).text = p1.scoreSheet[14].points.toString()
        findViewById<TextView>(R.id.totalP1TextView).text = p1.scoreSheet[17].points.toString()

        if(ObjectManager.listOfPlayers.size >= 2){
            //Displays player 2 data
            val p2 = ObjectManager.listOfPlayers[1]
            findViewById<TextView>(R.id.nameP2TextView).text = p2.name
            findViewById<TextView>(R.id.onesP2TextView).text = p2.scoreSheet[0].points.toString()
            findViewById<TextView>(R.id.twosP2TextView).text = p2.scoreSheet[1].points.toString()
            findViewById<TextView>(R.id.threesP2TextView).text = p2.scoreSheet[2].points.toString()
            findViewById<TextView>(R.id.foursP2TextView).text = p2.scoreSheet[3].points.toString()
            findViewById<TextView>(R.id.fivesP2TextView).text = p2.scoreSheet[4].points.toString()
            findViewById<TextView>(R.id.sixesP2TextView).text = p2.scoreSheet[5].points.toString()
            findViewById<TextView>(R.id.sumP2TextView).text = p2.scoreSheet[15].points.toString()
            findViewById<TextView>(R.id.bonusP2TextView).text = p2.scoreSheet[16].points.toString()
            findViewById<TextView>(R.id.onePairP2TextView).text = p2.scoreSheet[6].points.toString()
            findViewById<TextView>(R.id.twoPairsP2TextView).text = p2.scoreSheet[7].points.toString()
            findViewById<TextView>(R.id.toakP2TextView).text = p2.scoreSheet[8].points.toString()
            findViewById<TextView>(R.id.foakP2TextView).text = p2.scoreSheet[9].points.toString()
            findViewById<TextView>(R.id.fullHouseP2TextView).text = p2.scoreSheet[10].points.toString()
            findViewById<TextView>(R.id.smStraightP2TextView).text = p2.scoreSheet[11].points.toString()
            findViewById<TextView>(R.id.lgStraightP2TextView).text = p2.scoreSheet[12].points.toString()
            findViewById<TextView>(R.id.chanceP2TextView).text = p2.scoreSheet[13].points.toString()
            findViewById<TextView>(R.id.yatzyP2TextView).text = p2.scoreSheet[14].points.toString()
            findViewById<TextView>(R.id.totalP2TextView).text = p2.scoreSheet[17].points.toString()

            if(ObjectManager.listOfPlayers.size >= 3) {
                //Displays player 3 data
                val p3 = ObjectManager.listOfPlayers[2]
                findViewById<TextView>(R.id.nameP3TextView).text = p3.name
                findViewById<TextView>(R.id.onesP3TextView).text =
                    p3.scoreSheet[0].points.toString()
                findViewById<TextView>(R.id.twosP3TextView).text =
                    p3.scoreSheet[1].points.toString()
                findViewById<TextView>(R.id.threesP3TextView).text =
                    p3.scoreSheet[2].points.toString()
                findViewById<TextView>(R.id.foursP3TextView).text =
                    p3.scoreSheet[3].points.toString()
                findViewById<TextView>(R.id.fivesP3TextView).text =
                    p3.scoreSheet[4].points.toString()
                findViewById<TextView>(R.id.sixesP3TextView).text =
                    p3.scoreSheet[5].points.toString()
                findViewById<TextView>(R.id.sumP3TextView).text =
                    p3.scoreSheet[15].points.toString()
                findViewById<TextView>(R.id.bonusP3TextView).text =
                    p3.scoreSheet[16].points.toString()
                findViewById<TextView>(R.id.onePairP3TextView).text =
                    p3.scoreSheet[6].points.toString()
                findViewById<TextView>(R.id.twoPairsP3TextView).text =
                    p3.scoreSheet[7].points.toString()
                findViewById<TextView>(R.id.toakP3TextView).text =
                    p3.scoreSheet[8].points.toString()
                findViewById<TextView>(R.id.foakP3TextView).text =
                    p3.scoreSheet[9].points.toString()
                findViewById<TextView>(R.id.fullHouseP3TextView).text =
                    p3.scoreSheet[10].points.toString()
                findViewById<TextView>(R.id.smStraightP3TextView).text =
                    p3.scoreSheet[11].points.toString()
                findViewById<TextView>(R.id.lgStraightP3TextView).text =
                    p3.scoreSheet[12].points.toString()
                findViewById<TextView>(R.id.chanceP3TextView).text =
                    p3.scoreSheet[13].points.toString()
                findViewById<TextView>(R.id.yatzyP3TextView).text =
                    p3.scoreSheet[14].points.toString()
                findViewById<TextView>(R.id.totalP3TextView).text =
                    p3.scoreSheet[17].points.toString()

                if (ObjectManager.listOfPlayers.size >= 4) {
                    //Displays player 4 data
                    val p4 = ObjectManager.listOfPlayers[3]
                    findViewById<TextView>(R.id.nameP4TextView).text = p4.name
                    findViewById<TextView>(R.id.onesP4TextView).text =
                        p4.scoreSheet[0].points.toString()
                    findViewById<TextView>(R.id.twosP4TextView).text =
                        p4.scoreSheet[1].points.toString()
                    findViewById<TextView>(R.id.threesP4TextView).text =
                        p4.scoreSheet[2].points.toString()
                    findViewById<TextView>(R.id.foursP4TextView).text =
                        p4.scoreSheet[3].points.toString()
                    findViewById<TextView>(R.id.fivesP4TextView).text =
                        p4.scoreSheet[4].points.toString()
                    findViewById<TextView>(R.id.sixesP4TextView).text =
                        p4.scoreSheet[5].points.toString()
                    findViewById<TextView>(R.id.sumP4TextView).text =
                        p4.scoreSheet[15].points.toString()
                    findViewById<TextView>(R.id.bonusP4TextView).text =
                        p4.scoreSheet[16].points.toString()
                    findViewById<TextView>(R.id.onePairP4TextView).text =
                        p4.scoreSheet[6].points.toString()
                    findViewById<TextView>(R.id.twoPairsP4TextView).text =
                        p4.scoreSheet[7].points.toString()
                    findViewById<TextView>(R.id.toakP4TextView).text =
                        p4.scoreSheet[8].points.toString()
                    findViewById<TextView>(R.id.foakP4TextView).text =
                        p4.scoreSheet[9].points.toString()
                    findViewById<TextView>(R.id.fullHouseP4TextView).text =
                        p4.scoreSheet[10].points.toString()
                    findViewById<TextView>(R.id.smStraightP4TextView).text =
                        p4.scoreSheet[11].points.toString()
                    findViewById<TextView>(R.id.lgStraightP4TextView).text =
                        p4.scoreSheet[12].points.toString()
                    findViewById<TextView>(R.id.chanceP4TextView).text =
                        p4.scoreSheet[13].points.toString()
                    findViewById<TextView>(R.id.yatzyP4TextView).text =
                        p4.scoreSheet[14].points.toString()
                    findViewById<TextView>(R.id.totalP4TextView).text =
                        p4.scoreSheet[17].points.toString()

                    if (ObjectManager.listOfPlayers.size >= 5) {
                        //Displays player 5 data
                        val p5 = ObjectManager.listOfPlayers[4]
                        findViewById<TextView>(R.id.nameP5TextView).text = p5.name
                        findViewById<TextView>(R.id.onesP5TextView).text =
                            p5.scoreSheet[0].points.toString()
                        findViewById<TextView>(R.id.twosP5TextView).text =
                            p5.scoreSheet[1].points.toString()
                        findViewById<TextView>(R.id.threesP5TextView).text =
                            p5.scoreSheet[2].points.toString()
                        findViewById<TextView>(R.id.foursP5TextView).text =
                            p5.scoreSheet[3].points.toString()
                        findViewById<TextView>(R.id.fivesP5TextView).text =
                            p5.scoreSheet[4].points.toString()
                        findViewById<TextView>(R.id.sixesP5TextView).text =
                            p5.scoreSheet[5].points.toString()
                        findViewById<TextView>(R.id.sumP5TextView).text =
                            p5.scoreSheet[15].points.toString()
                        findViewById<TextView>(R.id.bonusP5TextView).text =
                            p5.scoreSheet[16].points.toString()
                        findViewById<TextView>(R.id.onePairP5TextView).text =
                            p5.scoreSheet[6].points.toString()
                        findViewById<TextView>(R.id.twoPairsP5TextView).text =
                            p5.scoreSheet[7].points.toString()
                        findViewById<TextView>(R.id.toakP5TextView).text =
                            p5.scoreSheet[8].points.toString()
                        findViewById<TextView>(R.id.foakP5TextView).text =
                            p5.scoreSheet[9].points.toString()
                        findViewById<TextView>(R.id.fullHouseP5TextView).text =
                            p5.scoreSheet[10].points.toString()
                        findViewById<TextView>(R.id.smStraightP5TextView).text =
                            p5.scoreSheet[11].points.toString()
                        findViewById<TextView>(R.id.lgStraightP5TextView).text =
                            p5.scoreSheet[12].points.toString()
                        findViewById<TextView>(R.id.chanceP5TextView).text =
                            p5.scoreSheet[13].points.toString()
                        findViewById<TextView>(R.id.yatzyP5TextView).text =
                            p5.scoreSheet[14].points.toString()
                        findViewById<TextView>(R.id.totalP5TextView).text =
                            p5.scoreSheet[17].points.toString()

                        if (ObjectManager.listOfPlayers.size == 6) {
                            //Displays player 6 data
                            val p6 = ObjectManager.listOfPlayers[5]
                            findViewById<TextView>(R.id.nameP6TextView).text = p6.name
                            findViewById<TextView>(R.id.onesP6TextView).text =
                                p6.scoreSheet[0].points.toString()
                            findViewById<TextView>(R.id.twosP6TextView).text =
                                p6.scoreSheet[1].points.toString()
                            findViewById<TextView>(R.id.threesP6TextView).text =
                                p6.scoreSheet[2].points.toString()
                            findViewById<TextView>(R.id.foursP6TextView).text =
                                p6.scoreSheet[3].points.toString()
                            findViewById<TextView>(R.id.fivesP6TextView).text =
                                p6.scoreSheet[4].points.toString()
                            findViewById<TextView>(R.id.sixesP6TextView).text =
                                p6.scoreSheet[5].points.toString()
                            findViewById<TextView>(R.id.sumP6TextView).text =
                                p6.scoreSheet[15].points.toString()
                            findViewById<TextView>(R.id.bonusP6TextView).text =
                                p6.scoreSheet[16].points.toString()
                            findViewById<TextView>(R.id.onePairP6TextView).text =
                                p6.scoreSheet[6].points.toString()
                            findViewById<TextView>(R.id.twoPairsP6TextView).text =
                                p6.scoreSheet[7].points.toString()
                            findViewById<TextView>(R.id.toakP6TextView).text =
                                p6.scoreSheet[8].points.toString()
                            findViewById<TextView>(R.id.foakP6TextView).text =
                                p6.scoreSheet[9].points.toString()
                            findViewById<TextView>(R.id.fullHouseP6TextView).text =
                                p6.scoreSheet[10].points.toString()
                            findViewById<TextView>(R.id.smStraightP6TextView).text =
                                p6.scoreSheet[11].points.toString()
                            findViewById<TextView>(R.id.lgStraightP6TextView).text =
                                p6.scoreSheet[12].points.toString()
                            findViewById<TextView>(R.id.chanceP6TextView).text =
                                p6.scoreSheet[13].points.toString()
                            findViewById<TextView>(R.id.yatzyP6TextView).text =
                                p6.scoreSheet[14].points.toString()
                            findViewById<TextView>(R.id.totalP6TextView).text =
                                p6.scoreSheet[17].points.toString()
                        }
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

