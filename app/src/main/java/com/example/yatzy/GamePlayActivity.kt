package com.example.yatzy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_game_play.*


class GamePlayActivity : AppCompatActivity() {

    val listOfPlayers = Players.listOfPlayers
    val listOfDieImageViews: MutableList<ImageView> = mutableListOf<ImageView>()
    var currentRound : Int = 0
    var currentPlayer = listOfPlayers.last()
    var recyclerPlayer = currentPlayer
    var listOfDice = mutableListOf<Die>()
    var scoreSheet = mutableListOf<Score>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_play)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = ScoreRecyclerAdapter(this, recyclerPlayer, )
        recyclerView.adapter = adapter

        createScoresheet()
        createDice()
        populateListOfDieImageViews()
        newTurn()
    }

    fun nextTurnOrScoreboard(view: View){
        if(currentRound == 2 && currentPlayer == listOfPlayers.last()){
            startScoreboardActivity()
        }
        if(currentPlayer == listOfPlayers.last()){
            currentPlayer = listOfPlayers.first()
            currentRound += 1
        }else{
            currentPlayer = listOfPlayers[+1]
        }
        newTurn()
    }
        //Starts next turn or scoreboard activity
    fun newTurn(){
        currentPlayer.alreadySaved = false

        findViewById<TextView>(R.id.getReadyTextView).text =
            getString(R.string.getReady, currentPlayer.name)
        findViewById<View>(R.id.getReadyLayout).visibility = View.VISIBLE
        findViewById<TextView>(R.id.whoIsPlayingTextView).text =
            getString(R.string.whoIsPlaying, currentPlayer.name)
        currentPlayer.rolls = 3
        findViewById<View>(R.id.rollTextView).visibility = View.INVISIBLE
        //UPDATE RECYCLER VIEW HERE
        }


    //Rolls dice
    fun rollDice(view: View){
        if (currentPlayer.rolls == 3){
            for(die in currentPlayer.listOfDice) {
                die.toBeRolled = true
            }

        }
        if(currentPlayer.rolls > 0){
            for(die in currentPlayer.listOfDice) {
                if (die.toBeRolled == true) {
                    die.currentValue =  (1..6).random()
                    die.toBeRolled = false
                }
            }
            currentPlayer.rolls -= 1
        }
        listOfDice = currentPlayer.listOfDice
        setDiceImages()
        findViewById<View>(R.id.getReadyLayout).visibility = View.INVISIBLE
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
        for(player in listOfPlayers) {
            for (i in 1..5) {
                player.listOfDice.add(Die())
            }
        }
    }

        //Creates a scoresheet for each player
    fun createScoresheet(){
        for(player in Players.listOfPlayers){
            player.scoreSheet.add(Ones())
            player.scoreSheet.add(Twos())
            player.scoreSheet.add(Threes())
            player.scoreSheet.add(Fours())
            player.scoreSheet.add(Fives())
            player.scoreSheet.add(Sixes())
            player.scoreSheet.add(Pair())
            player.scoreSheet.add(TwoPairs())
            player.scoreSheet.add(ThreeOfAKind())
            player.scoreSheet.add(FourOfAKind())
            player.scoreSheet.add(FullHouse())
            player.scoreSheet.add(SmStraight())
            player.scoreSheet.add(LgStraight())
            player.scoreSheet.add(Chance())
            player.scoreSheet.add(Yatzy())
        }
    }


        //Summarizes every player's bonus and score
    fun summarizePoints(){
        for(player in listOfPlayers){
            player.scoreSheet[15].points =
                player.scoreSheet[0].points + player.scoreSheet[1].points +
                player.scoreSheet[2].points + player.scoreSheet[3].points +
                player.scoreSheet[4].points + player.scoreSheet[5].points
        }
        for(player in listOfPlayers){
            if(player.scoreSheet[15].points >= 63){
                player.scoreSheet[16].points = 50
            }else{
                player.scoreSheet[16].points = 0
            }
        }
        for(player in listOfPlayers){
            player.scoreSheet[17].points =
                player.scoreSheet[6].points + player.scoreSheet[7].points +
                player.scoreSheet[8].points + player.scoreSheet[9].points +
                player.scoreSheet[10].points+ player.scoreSheet[11].points +
                player.scoreSheet[12].points + player.scoreSheet[13].points +
                player.scoreSheet[14].points + player.scoreSheet[15].points +
                player.scoreSheet[16].points
        }
    }

        //starts scoreboard activity and passes along names and scores
    fun startScoreboardActivity()   {
        summarizePoints()
        val scoreboardList :ArrayList<String> = arrayListOf()
        for(player in listOfPlayers){
            scoreboardList.add(player.name)
            scoreboardList.add(player.scoreSheet[17].points.toString())
        }
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
        setDieImage(listOfDice[0], listOfDieImageViews[0])
        setDieImage(listOfDice[1], listOfDieImageViews[1])
        setDieImage(listOfDice[2], listOfDieImageViews[2])
        setDieImage(listOfDice[3], listOfDieImageViews[3])
        setDieImage(listOfDice[4], listOfDieImageViews[4])

        if (listOfDice[0].toBeRolled == true ||
            listOfDice[1].toBeRolled == true ||
            listOfDice[2].toBeRolled == true ||
            listOfDice[3].toBeRolled == true ||
            listOfDice[4].toBeRolled == true){
            findViewById<View>(R.id.rollTextView).visibility = View.VISIBLE
        }else{
            findViewById<View>(R.id.rollTextView).visibility = View.INVISIBLE
        }

    }

        //Sets toBeRolled value and the white or red image accordingly for die 1
    fun selectOrDeselectDie1(view: View){
        if(currentPlayer.rolls >0) {
            when (listOfDice[0].toBeRolled) {
                false -> listOfDice[0].toBeRolled = true
                true -> listOfDice[0].toBeRolled = false
            }
        }
        setDiceImages()
    }
    //Sets toBeRolled value and the white or red image accordingly for die 2
    fun selectOrDeselectDie2(view: View){
        if(currentPlayer.rolls >0) {
            when (currentPlayer.listOfDice[1].toBeRolled) {
                false -> currentPlayer.listOfDice[1].toBeRolled = true
                true -> currentPlayer.listOfDice[1].toBeRolled = false
            }
        }
        setDiceImages()
    }
    //Sets toBeRolled value and the white or red image accordingly for die 3
    fun selectOrDeselectDie3(view: View){
        if(currentPlayer.rolls >0) {
            when (currentPlayer.listOfDice[2].toBeRolled) {
                false -> currentPlayer.listOfDice[2].toBeRolled = true
                true -> currentPlayer.listOfDice[2].toBeRolled = false
            }
        }
        setDiceImages()
    }
    //Sets toBeRolled value and the white or red image accordingly for die 4
    fun selectOrDeselectDie4(view: View){
        if(currentPlayer.rolls >0) {
            when (currentPlayer.listOfDice[3].toBeRolled) {
                false -> currentPlayer.listOfDice[3].toBeRolled = true
                true -> currentPlayer.listOfDice[3].toBeRolled = false
            }
        }
        setDiceImages()
    }
    //Sets toBeRolled value and the white or red image accordingly for die 5
    fun selectOrDeselectDie5(view: View){
        if(currentPlayer.rolls >0) {
            when (currentPlayer.listOfDice[4].toBeRolled) {
                false -> currentPlayer.listOfDice[4].toBeRolled = true
                true -> currentPlayer.listOfDice[4].toBeRolled = false
            }
        }
        setDiceImages()
    }


}