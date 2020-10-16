package com.example.yatzy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class GamePlayActivity : AppCompatActivity() {

    val listOfDieImageViews: MutableList<ImageView> = mutableListOf<ImageView>()
    val totalRounds = 15
    var currentRound = 1
    var turnsInEveryRound = ObjectManager.listOfPlayers.lastIndex
    var currentPlayerNr = 0
    var listOfDice = mutableListOf<Die>()
    lateinit var adapter: ScoreRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_play)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = ScoreRecyclerAdapter(this )
        recyclerView.adapter = adapter

        createDice()
        populateListOfDieImageViews()
        startTurn()
    }

    fun hideTapToSelect(){
        findViewById<TextView>(R.id.tapToSelectTextView).visibility = View.INVISIBLE
    }

        //Checks that user has saved and reminds otherwise.
        //Then starts next turn, a new round, or scoreboard.
    fun nextPlayerOrScoreboard(view: View){
        if(ObjectManager.currentPlayer.alreadySaved){
            if(currentPlayerNr == turnsInEveryRound && currentRound == totalRounds){
                startScoreboardActivity()
            }else {
                nextPlayer()
                startTurn()
            }
        }else{
            Toast.makeText(this, "${getString(R.string.saveFirst)}", Toast.LENGTH_SHORT).show()
        }
    }

        //Sets currentPlayer to next player up
    fun nextPlayer(){
        if(currentPlayerNr == turnsInEveryRound) {
            currentPlayerNr = 0
            currentRound++
        }else{
            currentPlayerNr++
        }
        ObjectManager.currentPlayer = ObjectManager.listOfPlayers[currentPlayerNr]
    }


    fun startTurn(){
        ObjectManager.currentPlayer.alreadySaved = false
        ObjectManager.currentPlayer.rolls = 3
        findViewById<ImageView>(R.id.rollingDiceImageView).visibility = View.VISIBLE
        findViewById<TextView>(R.id.getReadyTextView).text =
            getString(R.string.getReady, ObjectManager.currentPlayer.name)
        findViewById<View>(R.id.getReadyLayout).visibility = View.VISIBLE
        findViewById<TextView>(R.id.whoIsPlayingTextView).text =
            getString(R.string.whoIsPlaying, ObjectManager.currentPlayer.name)
        findViewById<View>(R.id.rollTextView).visibility = View.INVISIBLE
    }


    fun startPlay(view: View){
        for(die in listOfDieImageViews){
            die.visibility = View.INVISIBLE
        }
        findViewById<TextView>(R.id.tapToSelectTextView).visibility = View.INVISIBLE
        findViewById<TextView>(R.id.rollTextView).visibility = View.VISIBLE
        adapter.notifyDataSetChanged()
        findViewById<View>(R.id.getReadyLayout).visibility = View.INVISIBLE

    }

    //Rolls dice, applys correct images and makes them visible
    fun rollDice(view: View){
        findViewById<ImageView>(R.id.rollingDiceImageView).visibility = View.INVISIBLE
        if (ObjectManager.currentPlayer.rolls == 3){
            for(die in ObjectManager.currentPlayer.listOfDice) {
                die.toBeRolled = true
            }

        }
        if(ObjectManager.currentPlayer.rolls > 0){
            for(die in ObjectManager.currentPlayer.listOfDice) {
                if (die.toBeRolled == true) {
                    die.currentValue =  (1..6).random()
                    die.toBeRolled = false
                }
            }
            ObjectManager.currentPlayer.rolls -= 1
        }
        listOfDice = ObjectManager.currentPlayer.listOfDice
        setDiceImages()
        for(die in listOfDieImageViews){
            die.visibility = View.VISIBLE
        }
        if(ObjectManager.currentPlayer.rolls >= 1) {
            findViewById<TextView>(R.id.tapToSelectTextView).visibility = View.VISIBLE
        }else{
            findViewById<TextView>(R.id.tapToSelectTextView).visibility = View.INVISIBLE
        }
        findViewById<TextView>(R.id.rollTextView).visibility = View.INVISIBLE
    }

    //populates list of die images
    fun populateListOfDieImageViews(){
        listOfDieImageViews.add(findViewById(R.id.die1))
        listOfDieImageViews.add(findViewById(R.id.die2))
        listOfDieImageViews.add(findViewById(R.id.die3))
        listOfDieImageViews.add(findViewById(R.id.die4))
        listOfDieImageViews.add(findViewById(R.id.die5))
    }

        //Creates a set of dice for each player
    fun createDice(){
        for(player in ObjectManager.listOfPlayers) {
            for (i in 1..5) {
                player.listOfDice.add(Die())
            }
        }
    }



        //starts scoreboard activity
    fun startScoreboardActivity()   {
        val intent = Intent(this, ScoreboardActivity::class.java)
        startActivity(intent)
    }


        //Sets correct die image according to value and selected-state to one die
    fun setDieImage(die : Die, dieView: ImageView){
        when(die.toBeRolled){
            false ->    when(die.currentValue){
                            1 -> dieView.setImageResource(R.drawable.die1)
                            2 -> dieView.setImageResource(R.drawable.die2)
                            3 -> dieView.setImageResource(R.drawable.die3)
                            4 -> dieView.setImageResource(R.drawable.die4)
                            5 -> dieView.setImageResource(R.drawable.die5)
                            6 -> dieView.setImageResource(R.drawable.die6)
                            }
            true ->     when(die.currentValue){
                            1 -> dieView.setImageResource(R.drawable.die1selected)
                            2 -> dieView.setImageResource(R.drawable.die2selected)
                            3 -> dieView.setImageResource(R.drawable.die3selected)
                            4 -> dieView.setImageResource(R.drawable.die4selected)
                            5 -> dieView.setImageResource(R.drawable.die5selected)
                            6 -> dieView.setImageResource(R.drawable.die6selected)
                            }
        }
    }

        //Uses setDieImage to set correct images on all dice and shows/hides roll button
    fun setDiceImages(){
        setDieImage(listOfDice[0], findViewById(R.id.die1))
        setDieImage(listOfDice[1], findViewById(R.id.die2))
        setDieImage(listOfDice[2], findViewById(R.id.die3))
        setDieImage(listOfDice[3], findViewById(R.id.die4))
        setDieImage(listOfDice[4], findViewById(R.id.die5))

        if (listOfDice[0].toBeRolled == true ||
            listOfDice[1].toBeRolled == true ||
            listOfDice[2].toBeRolled == true ||
            listOfDice[3].toBeRolled == true ||
            listOfDice[4].toBeRolled == true){
            findViewById<TextView>(R.id.rollTextView).visibility = View.VISIBLE
            findViewById<TextView>(R.id.tapToSelectTextView).visibility = View.INVISIBLE
        }else{
            findViewById<TextView>(R.id.rollTextView).visibility = View.INVISIBLE
            findViewById<TextView>(R.id.tapToSelectTextView).visibility = View.VISIBLE
        }
    }



        //Sets toBeRolled value and the white or red image accordingly for a die
        //(Selects or deselects ONE die and shows correct images for ALL die)
    fun selectOrDeselectDie(view: View){
        if(ObjectManager.currentPlayer.alreadySaved == false) {
            if (ObjectManager.currentPlayer.rolls > 0) {
                when (view.id) {
                    R.id.die1 -> when (listOfDice[0].toBeRolled) {
                        false -> listOfDice[0].toBeRolled = true
                        true -> listOfDice[0].toBeRolled = false
                    }
                    R.id.die2 -> when (listOfDice[1].toBeRolled) {
                        false -> listOfDice[1].toBeRolled = true
                        true -> listOfDice[1].toBeRolled = false
                    }
                    R.id.die3 -> when (listOfDice[2].toBeRolled) {
                        false -> listOfDice[2].toBeRolled = true
                        true -> listOfDice[2].toBeRolled = false
                    }
                    R.id.die4 -> when (listOfDice[3].toBeRolled) {
                        false -> listOfDice[3].toBeRolled = true
                        true -> listOfDice[3].toBeRolled = false
                    }
                    R.id.die5 -> when (listOfDice[4].toBeRolled) {
                        false -> listOfDice[4].toBeRolled = true
                        true -> listOfDice[4].toBeRolled = false
                    }
                }
                setDiceImages()
            } else {
                Toast.makeText(this, "${getString(R.string.noMoreRolls)}",
                    Toast.LENGTH_SHORT).show()
            }
        }else{
            Toast.makeText(this, "${getString(R.string.youAlreadySaved)}",
                Toast.LENGTH_SHORT).show()
        }
    }



}