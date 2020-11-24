package com.example.yatzy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class GamePlayActivity : AppCompatActivity() {

    val listOfDieImageViews: MutableList<ImageView> = mutableListOf<ImageView>()
    val totalRounds = 1
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

    override fun onBackPressed() {
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
        findViewById<TextView>(R.id.whoIsPlayingTextView).text =
            getString(R.string.whoIsPlaying, ObjectManager.currentPlayer.name)
        addGetReadyFragment()

        findViewById<ImageView>(R.id.rollingDiceImageView).visibility = View.VISIBLE
        /*findViewById<TextView>(R.id.getReadyTextView).text =
            getString(R.string.getReady, ObjectManager.currentPlayer.name)
        findViewById<View>(R.id.getReadyLayout).visibility = View.VISIBLE

        findViewById<View>(R.id.rollTextView).visibility = View.INVISIBLE*/
            }


    fun startPlay(view: View){
        for(die in listOfDieImageViews){
            die.visibility = View.INVISIBLE
        }
        findViewById<TextView>(R.id.tapToSelectTextView).visibility = View.INVISIBLE
        findViewById<TextView>(R.id.rollTextView).visibility = View.VISIBLE
        adapter.notifyDataSetChanged()
        //findViewById<View>(R.id.getReadyLayout).visibility = View.INVISIBLE
        removeGetReadyFragment()
    }

    //Rolls dice, applies correct images and makes them visible
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
                    die.image = (1..4).random()
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

    fun addGetReadyFragment(){

        val getReadyFragment = GetReadyFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.containerMain, getReadyFragment, "getReadyFragment")
        transaction.commit()
    }

    fun removeGetReadyFragment(){
        val getReadyFragment = supportFragmentManager.findFragmentByTag("getReadyFragment")
        if(getReadyFragment != null) {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.remove(getReadyFragment)
            transaction.commit()
        }else{
            Toast.makeText(this, "Fragment not found", Toast.LENGTH_SHORT).show()
        }
    }

    fun addHelpFragment(view: View){

        val helpFragment = HelpFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.containerMain, helpFragment, "helpFragment")
        transaction.commit()
    }

    fun removeHelpFragment(view: View){
        val helpFragment = supportFragmentManager.findFragmentByTag("helpFragment")
        if(helpFragment != null) {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.remove(helpFragment)
            transaction.commit()
        }else{
            Toast.makeText(this, "Fragment not found", Toast.LENGTH_SHORT).show()
        }
    }



    //populates list of die images
    fun populateListOfDieImageViews(){
        listOfDieImageViews.add(findViewById(R.id.die1ImageView))
        listOfDieImageViews.add(findViewById(R.id.die2ImageView))
        listOfDieImageViews.add(findViewById(R.id.die3ImageView))
        listOfDieImageViews.add(findViewById(R.id.die4ImageView))
        listOfDieImageViews.add(findViewById(R.id.die5ImageView))
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


        //Sets correct die image according to value and selected-state to ONE die
    fun setDieImage(die : Die, dieImageView: ImageView){
        when(die.toBeRolled){
            false ->    when(die.currentValue){
                            1 -> {when (die.image) {
                                1 -> dieImageView.setImageResource(R.drawable.die11)
                                2 -> dieImageView.setImageResource(R.drawable.die12)
                                3 -> dieImageView.setImageResource(R.drawable.die13)
                                4 -> dieImageView.setImageResource(R.drawable.die14)
                                }
                            }
                            2 -> {when (die.image) {
                                1 -> dieImageView.setImageResource(R.drawable.die21)
                                2 -> dieImageView.setImageResource(R.drawable.die22)
                                3 -> dieImageView.setImageResource(R.drawable.die23)
                                4 -> dieImageView.setImageResource(R.drawable.die24)
                                }
                            }
                            3 -> {when (die.image) {
                                1 -> dieImageView.setImageResource(R.drawable.die31)
                                2 -> dieImageView.setImageResource(R.drawable.die32)
                                3 -> dieImageView.setImageResource(R.drawable.die33)
                                4 -> dieImageView.setImageResource(R.drawable.die34)
                                }
                            }
                            4 -> {when (die.image) {
                                1 -> dieImageView.setImageResource(R.drawable.die41)
                                2 -> dieImageView.setImageResource(R.drawable.die42)
                                3 -> dieImageView.setImageResource(R.drawable.die43)
                                4 -> dieImageView.setImageResource(R.drawable.die44)
                                }
                            }
                            5 -> {when (die.image) {
                                1 -> dieImageView.setImageResource(R.drawable.die51)
                                2 -> dieImageView.setImageResource(R.drawable.die52)
                                3 -> dieImageView.setImageResource(R.drawable.die53)
                                4 -> dieImageView.setImageResource(R.drawable.die54)
                                }
                            }
                            6 -> {when (die.image) {
                                1 -> dieImageView.setImageResource(R.drawable.die61)
                                2 -> dieImageView.setImageResource(R.drawable.die62)
                                3 -> dieImageView.setImageResource(R.drawable.die63)
                                4 -> dieImageView.setImageResource(R.drawable.die64)
                                }
                            }
                        }
            true ->     when(die.currentValue){
                            1 -> {when (die.image) {
                                1 -> dieImageView.setImageResource(R.drawable.die11dark)
                                2 -> dieImageView.setImageResource(R.drawable.die12dark)
                                3 -> dieImageView.setImageResource(R.drawable.die13dark)
                                4 -> dieImageView.setImageResource(R.drawable.die14dark)
                                }
                            }
                            2 -> {when (die.image) {
                                1 -> dieImageView.setImageResource(R.drawable.die21dark)
                                2 -> dieImageView.setImageResource(R.drawable.die22dark)
                                3 -> dieImageView.setImageResource(R.drawable.die23dark)
                                4 -> dieImageView.setImageResource(R.drawable.die24dark)
                                }
                            }
                            3 -> {when (die.image) {
                                1 -> dieImageView.setImageResource(R.drawable.die31dark)
                                2 -> dieImageView.setImageResource(R.drawable.die32dark)
                                3 -> dieImageView.setImageResource(R.drawable.die33dark)
                                4 -> dieImageView.setImageResource(R.drawable.die34dark)
                                }
                            }
                            4 -> {when (die.image) {
                                1 -> dieImageView.setImageResource(R.drawable.die41dark)
                                2 -> dieImageView.setImageResource(R.drawable.die42dark)
                                3 -> dieImageView.setImageResource(R.drawable.die43dark)
                                4 -> dieImageView.setImageResource(R.drawable.die44dark)
                                }
                            }
                            5  -> {when (die.image) {
                                1 -> dieImageView.setImageResource(R.drawable.die51dark)
                                2 -> dieImageView.setImageResource(R.drawable.die52dark)
                                3 -> dieImageView.setImageResource(R.drawable.die53dark)
                                4 -> dieImageView.setImageResource(R.drawable.die54dark)
                                }
                            }
                            6 -> {when (die.image) {
                                1 -> dieImageView.setImageResource(R.drawable.die61dark)
                                2 -> dieImageView.setImageResource(R.drawable.die62dark)
                                3 -> dieImageView.setImageResource(R.drawable.die63dark)
                                4 -> dieImageView.setImageResource(R.drawable.die64dark)
                                }
                            }
            }
        }
    }

        //Uses setDieImage to set correct images on all dice and shows/hides roll button
    fun setDiceImages(){
        setDieImage(listOfDice[0], findViewById(R.id.die1ImageView))
        setDieImage(listOfDice[1], findViewById(R.id.die2ImageView))
        setDieImage(listOfDice[2], findViewById(R.id.die3ImageView))
        setDieImage(listOfDice[3], findViewById(R.id.die4ImageView))
        setDieImage(listOfDice[4], findViewById(R.id.die5ImageView))

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



        //Sets toBeRolled value and greys out dice that will be rolled
        //(Selects or deselects ONE die and shows correct images for ALL dice)
    fun selectOrDeselectDie(view: View){
        if(ObjectManager.currentPlayer.alreadySaved == false) {
            if (ObjectManager.currentPlayer.rolls > 0) {
                when (view.id) {
                    R.id.die1ImageView -> when (listOfDice[0].toBeRolled) {
                        false -> listOfDice[0].toBeRolled = true
                        true -> listOfDice[0].toBeRolled = false
                    }
                    R.id.die2ImageView -> when (listOfDice[1].toBeRolled) {
                        false -> listOfDice[1].toBeRolled = true
                        true -> listOfDice[1].toBeRolled = false
                    }
                    R.id.die3ImageView -> when (listOfDice[2].toBeRolled) {
                        false -> listOfDice[2].toBeRolled = true
                        true -> listOfDice[2].toBeRolled = false
                    }
                    R.id.die4ImageView -> when (listOfDice[3].toBeRolled) {
                        false -> listOfDice[3].toBeRolled = true
                        true -> listOfDice[3].toBeRolled = false
                    }
                    R.id.die5ImageView -> when (listOfDice[4].toBeRolled) {
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
            val toast = Toast.makeText(this, "${getString(R.string.youAlreadySaved)}",Toast.LENGTH_SHORT)
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0)
            toast.show()
        }
    }



}