package com.example.yatzy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class GamePlayActivity : AppCompatActivity() {

    val listOfPlayers = Players.listOfPlayers
    val listOfDieImageViews: MutableList<ImageView> = mutableListOf<ImageView>()
    var currentRound : Int = 0
    var currentPlayer = listOfPlayers.last()
    var recyclerPlayer = currentPlayer


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

    fun savePoints(scorePosition : Int){
        Log.d("!!!", "savePoints started")
        currentPlayer.scoreSheet[scorePosition].saveScore(currentPlayer)
        Log.d("!!!", "${currentPlayer.scoreSheet[0].points.toString()}")
        Log.d("!!!", "${currentPlayer.scoreSheet[6].points.toString()}")

        if(currentRound == 1 && currentPlayer == listOfPlayers.last()){
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
        //Starts next turn
    fun newTurn(){
        Log.d("!!!", "newTurn started")
        Log.d("!!!", "${currentPlayer.scoreSheet[0].points.toString()}")
        Log.d("!!!", "${currentPlayer.scoreSheet[6].points.toString()}")
        hideEverything()
        Log.d("!!!", "hideEverything done")
        findViewById<TextView>(R.id.whoIsPlayingTextView).text = getString(R.string.whoIsPlaying, currentPlayer.name)
        currentPlayer.rolls = 3
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


    fun hideEverything(){
        Log.d("!!!", "HideEverything started")
        findViewById<ImageView>(R.id.die1).visibility =View.INVISIBLE
        findViewById<ImageView>(R.id.die2).visibility =View.INVISIBLE
        findViewById<ImageView>(R.id.die3).visibility =View.INVISIBLE
        findViewById<ImageView>(R.id.die4).visibility =View.INVISIBLE
        findViewById<ImageView>(R.id.die5).visibility =View.INVISIBLE

        findViewById<TextView>(R.id.selectTextView).visibility =View.INVISIBLE

        findViewById<RecyclerView>(R.id.recyclerView).visibility = View.INVISIBLE
        Log.d("!!!", "hideEverything end")
    }

    fun showEverything(){
        findViewById<ImageView>(R.id.die1).visibility =View.VISIBLE
        findViewById<ImageView>(R.id.die2).visibility =View.VISIBLE
        findViewById<ImageView>(R.id.die3).visibility =View.VISIBLE
        findViewById<ImageView>(R.id.die4).visibility =View.VISIBLE
        findViewById<ImageView>(R.id.die5).visibility =View.VISIBLE

        findViewById<TextView>(R.id.selectTextView).visibility =View.VISIBLE

        findViewById<RecyclerView>(R.id.recyclerView).visibility = View.VISIBLE
    }

        //Summarizes every player's bonus and score
    fun sumPoints(){
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
        sumPoints()
        val scoreboardList :ArrayList<String> = arrayListOf()
        for(player in listOfPlayers){
            scoreboardList.add(player.name)
            scoreboardList.add(player.scoreSheet[17].points.toString())
        }
        val intent = Intent(this, ScoreboardActivity::class.java)
        startActivity(intent)
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
        setDiceImages()
        showEverything()
    }

        //Sets correct die image according to value and selected-state to a die
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

        //Uses setDieImage to set the right die images on all dice
    fun setDiceImages(){
        setDieImage(currentPlayer.listOfDice[0], listOfDieImageViews[0])
        setDieImage(currentPlayer.listOfDice[1], listOfDieImageViews[1])
        setDieImage(currentPlayer.listOfDice[2], listOfDieImageViews[2])
        setDieImage(currentPlayer.listOfDice[3], listOfDieImageViews[3])
        setDieImage(currentPlayer.listOfDice[4], listOfDieImageViews[4])
    }

        //Sets toBeRolled value and the white or red image accordingly for die 1
    fun selectAndDeselectDie1(view: View){
        when(currentPlayer.listOfDice[0].toBeRolled){
            false -> currentPlayer.listOfDice[0].toBeRolled = true
            true -> currentPlayer.listOfDice[0].toBeRolled = false
        }
        setDieImage(currentPlayer.listOfDice[0], listOfDieImageViews[0])
    }
    //Sets toBeRolled value and the white or red image accordingly for die 2
    fun selectAndDeselectDie2(view: View){
        when(currentPlayer.listOfDice[1].toBeRolled){
            false -> currentPlayer.listOfDice[1].toBeRolled = true
            true -> currentPlayer.listOfDice[1].toBeRolled = false
        }
        setDieImage(currentPlayer.listOfDice[1], listOfDieImageViews[1])
    }
    //Sets toBeRolled value and the white or red image accordingly for die 3
    fun selectDie3(view: View){
        when(currentPlayer.listOfDice[2].toBeRolled){
            false -> currentPlayer.listOfDice[2].toBeRolled = true
            true -> currentPlayer.listOfDice[2].toBeRolled = false
        }
        setDieImage(currentPlayer.listOfDice[2], listOfDieImageViews[2])
    }
    //Sets toBeRolled value and the white or red image accordingly for die 4
    fun selectDie4(view: View){
        when(currentPlayer.listOfDice[3].toBeRolled){
            false -> currentPlayer.listOfDice[3].toBeRolled = true
            true -> currentPlayer.listOfDice[3].toBeRolled = false
        }
        setDieImage(currentPlayer.listOfDice[3], listOfDieImageViews[3])
    }
    //Sets toBeRolled value and the white or red image accordingly for die 5
    fun selectDie5(view: View){
        when(currentPlayer.listOfDice[4].toBeRolled){
            false -> currentPlayer.listOfDice[4].toBeRolled = true
            true -> currentPlayer.listOfDice[4].toBeRolled = false
        }
        setDieImage(currentPlayer.listOfDice[4], listOfDieImageViews[4])
    }

  /*      //Methods to call points setters and start next turn
    fun saveOnes(){
        currentPlayer.setOnes()
        newTurn()
    }

    fun saveTwos(view: View){
        currentPlayer.setTwos()
        newTurn()
    }

    fun saveThrees(view: View){
        currentPlayer.setThrees()
        newTurn()
    }

    fun saveFours(view: View){
        currentPlayer.setFours()
        newTurn()
    }

    fun saveFives(view: View){
        currentPlayer.setFives()
        newTurn()
    }

    fun saveSixes(view: View){
        currentPlayer.setSixes()
        newTurn()
    }

    fun saveOnePair(view: View){
        currentPlayer.setOnePair()
        newTurn()
    }

    fun saveTwoPairs(view: View){
        currentPlayer.setTwoPairs()
        newTurn()
    }

    fun saveTrips(view: View){
        currentPlayer.setTrips()
        newTurn()
    }

    fun saveFourOfAKind(view: View){
        currentPlayer.setFourOfAKind()
        newTurn()
    }

    fun saveFullHouse(view: View){
        currentPlayer.setFullHouse()
        newTurn()
    }

    fun saveSmStraight(view: View){
        currentPlayer.setSmStraight()
        newTurn()
    }

    fun saveLgStraight(view: View){
        currentPlayer.setLgStraight()
        newTurn()
    }

    fun saveChance(view: View){
        currentPlayer.setChance()
        newTurn()
    }

    fun saveYatzy(view: View){
        currentPlayer.setYatzy()
        newTurn()
    }*/
}