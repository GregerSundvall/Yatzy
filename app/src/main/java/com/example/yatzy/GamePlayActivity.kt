package com.example.yatzy

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_game_play.*
import kotlinx.android.synthetic.main.activity_scoreboard.*

class GamePlayActivity : AppCompatActivity() {

    val listOfPlayers: MutableList<Player> = mutableListOf<Player>()
    val listOfDieImageViews: MutableList<ImageView> = mutableListOf<ImageView>()
    var nrOfPlayers : Int = 0
    var currentRound : Int = 0
    lateinit var currentPlayer :Player
    lateinit var nameTextView : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_play)

        //Adds received list of player names to players list
        var listOfPlayerNames = intent.getStringArrayListExtra("listOfPlayerNames")
        //listOfPlayerNames!!.reverse()
        if (listOfPlayerNames != null) {
            for (name in listOfPlayerNames) {
                listOfPlayers.add(Player(name))
            }
        }

        setupScoresheet()
        setupDice()
        setupListOfDieImageViews()
        currentPlayer = listOfPlayers.last()

        newTurn()
    }

    fun newTurn(){
        hideStuff()
        if(currentRound == 15 && currentPlayer == listOfPlayers.last()){
            startScoreboardActivity()
        }
        if(currentPlayer == listOfPlayers.last()){
            currentPlayer = listOfPlayers.first()
            currentRound += 1
        }else{
            currentPlayer = listOfPlayers[+1]
        }

        findViewById<TextView>(R.id.whoIsPlayingTextView).text = getString(R.string.whoIsPlaying, currentPlayer.name)


        currentPlayer.rolls = 3
        Log.d("!!!", "pausläget")
    }

        //populates list of die images
    fun setupListOfDieImageViews(){
        //adds die imageviews to list
        listOfDieImageViews.add(findViewById(R.id.die1))
        listOfDieImageViews.add(findViewById(R.id.die2))
        listOfDieImageViews.add(findViewById(R.id.die3))
        listOfDieImageViews.add(findViewById(R.id.die4))
        listOfDieImageViews.add(findViewById(R.id.die5))

    }

        //Adds a set of dice for each player
    fun setupDice(){
        for(player in listOfPlayers) {
            for (i in 1..5) {
                player.listOfDice.add(Die())
            }
        }
    }

        //Sets up a scoresheet for each player
    fun setupScoresheet(){
        for (player in listOfPlayers) {
            player.scoreSheet.add(Score(1, "Aces"))
        }
        for (player in listOfPlayers) {
            player.scoreSheet.add(Score(2, "Twos"))
        }
        for (player in listOfPlayers) {
            player.scoreSheet.add(Score(3, "Threes"))
        }
        for (player in listOfPlayers) {
            player.scoreSheet.add(Score(4, "Fours"))
        }
        for (player in listOfPlayers) {
            player.scoreSheet.add(Score(5, "Fives"))
        }
        for (player in listOfPlayers) {
            player.scoreSheet.add(Score(6, "Sixes"))
        }
        for (player in listOfPlayers) {
            player.scoreSheet.add(Score(7, "Sum"))
        }
        for (player in listOfPlayers) {
            player.scoreSheet.add(Score(8, "Bonus"))
        }
        for (player in listOfPlayers) {
            player.scoreSheet.add(Score(9, "Pair"))
        }
        for (player in listOfPlayers) {
            player.scoreSheet.add(Score(10, "Two pairs"))
        }
        for (player in listOfPlayers) {
            player.scoreSheet.add(Score(11, "3 of a kind"))
        }
        for (player in listOfPlayers) {
            player.scoreSheet.add(Score(12, "4 of a kind"))
        }
        for (player in listOfPlayers) {
            player.scoreSheet.add(Score(13, "Full house"))
        }
        for (player in listOfPlayers) {
            player.scoreSheet.add(Score(14, "SM straight"))
        }
        for (player in listOfPlayers) {
            player.scoreSheet.add(Score(15, "LG straight"))
        }
        for (player in listOfPlayers) {
            player.scoreSheet.add(Score(16, "Chance"))
        }
        for (player in listOfPlayers) {
            player.scoreSheet.add(Score(17, "Yahtzee"))
        }
        for (player in listOfPlayers) {
            player.scoreSheet.add(Score(18, "Total"))
        }
    }

        //Prints points for used slots on screen
    fun showPlayerPoints(){
        findViewById<TextView>(R.id.onesTextView).text = getString(R.string.onesPoints, currentPlayer.scoreSheet[0].points.toString())
        findViewById<TextView>(R.id.twosTextView).text = getString(R.string.twosPoints, currentPlayer.scoreSheet[1].points.toString())
        findViewById<TextView>(R.id.threesTextView).text = getString(R.string.threesPoints, currentPlayer.scoreSheet[2].points.toString())
        findViewById<TextView>(R.id.foursTextView).text = getString(R.string.foursPoints, currentPlayer.scoreSheet[3].points.toString())
        findViewById<TextView>(R.id.fivesTextView).text = getString(R.string.fivesPoints, currentPlayer.scoreSheet[4].points.toString())
        findViewById<TextView>(R.id.sixesTextView).text = getString(R.string.sixesPoints, currentPlayer.scoreSheet[5].points.toString())
        findViewById<TextView>(R.id.onePairTextView).text = getString(R.string.onePairPoints, currentPlayer.scoreSheet[8].points.toString())
        findViewById<TextView>(R.id.twoPairsTextView).text = getString(R.string.twoPairsPoints, currentPlayer.scoreSheet[9].points.toString())
        findViewById<TextView>(R.id.tripsTextView).text = getString(R.string.tripsPoints, currentPlayer.scoreSheet[10].points.toString())
        findViewById<TextView>(R.id.fourOfAKindTextView).text = getString(R.string.fourOfAKindPoints, currentPlayer.scoreSheet[11].points.toString())
        findViewById<TextView>(R.id.fullHouseTextView).text = getString(R.string.fullHousePoints, currentPlayer.scoreSheet[12].points.toString())
        findViewById<TextView>(R.id.smStraightTextView).text = getString(R.string.smStraightPoints, currentPlayer.scoreSheet[13].points.toString())
        findViewById<TextView>(R.id.lgStraightTextView).text = getString(R.string.lgStraightPoints, currentPlayer.scoreSheet[14].points.toString())
        findViewById<TextView>(R.id.chanceTextView).text = getString(R.string.chancePoints, currentPlayer.scoreSheet[15].points.toString())
        findViewById<TextView>(R.id.yatzyTextView).text = getString(R.string.yatzyPoints, currentPlayer.scoreSheet[16].points.toString())

    }

        //Hides buttons for already used slots and shows everything else.
    fun showHideButtons(){
        if(currentPlayer.scoreSheet[0].visible == false) {
            findViewById<Button>(R.id.buttonOnes).visibility = View.INVISIBLE
        }else{
            findViewById<Button>(R.id.buttonOnes).visibility = View.VISIBLE
        }
        if(currentPlayer.scoreSheet[1].visible == false) {
            findViewById<Button>(R.id.buttonTwos).visibility = View.INVISIBLE
        }else{
            findViewById<Button>(R.id.buttonTwos).visibility = View.VISIBLE
        }
        if(currentPlayer.scoreSheet[2].visible == false) {
            findViewById<Button>(R.id.buttonThrees).visibility = View.INVISIBLE
        }else{
            findViewById<Button>(R.id.buttonThrees).visibility = View.VISIBLE
        }
        if(currentPlayer.scoreSheet[3].visible == false) {
            findViewById<Button>(R.id.buttonFours).visibility = View.INVISIBLE
        }else{
            findViewById<Button>(R.id.buttonFours).visibility = View.VISIBLE
        }
        if(currentPlayer.scoreSheet[4].visible == false) {
            findViewById<Button>(R.id.buttonFives).visibility = View.INVISIBLE
        }else{
            findViewById<Button>(R.id.buttonFives).visibility = View.VISIBLE
        }
        if(currentPlayer.scoreSheet[5].visible == false) {
            findViewById<Button>(R.id.buttonSixes).visibility = View.INVISIBLE
        }else{
            findViewById<Button>(R.id.buttonSixes).visibility = View.VISIBLE
        }
        if(currentPlayer.scoreSheet[8].visible == false) {
            findViewById<Button>(R.id.buttonOnePair).visibility = View.INVISIBLE
        }else{
            findViewById<Button>(R.id.buttonOnePair).visibility = View.VISIBLE
        }
        if(currentPlayer.scoreSheet[9].visible == false) {
            findViewById<Button>(R.id.buttonTwoPairs).visibility = View.INVISIBLE
        }else{
            findViewById<Button>(R.id.buttonTwoPairs).visibility = View.VISIBLE
        }
        if(currentPlayer.scoreSheet[10].visible == false) {
            findViewById<Button>(R.id.buttonTrips).visibility = View.INVISIBLE
        }else{
            findViewById<Button>(R.id.buttonTrips).visibility = View.VISIBLE
        }
        if(currentPlayer.scoreSheet[11].visible == false) {
            findViewById<Button>(R.id.buttonFourOfAKind).visibility = View.INVISIBLE
        }else{
            findViewById<Button>(R.id.buttonFourOfAKind).visibility = View.VISIBLE
        }
        if(currentPlayer.scoreSheet[12].visible == false) {
            findViewById<Button>(R.id.buttonFullHouse).visibility = View.INVISIBLE
        }else{
            findViewById<Button>(R.id.buttonFullHouse).visibility = View.VISIBLE
        }
        if(currentPlayer.scoreSheet[13].visible == false) {
            findViewById<Button>(R.id.buttonSmallStraight).visibility = View.INVISIBLE
        }else{
            findViewById<Button>(R.id.buttonSmallStraight).visibility = View.VISIBLE
        }
        if(currentPlayer.scoreSheet[14].visible == false) {
            findViewById<Button>(R.id.buttonLargeStraight).visibility = View.INVISIBLE
        }else{
            findViewById<Button>(R.id.buttonLargeStraight).visibility = View.VISIBLE
        }
        if(currentPlayer.scoreSheet[15].visible == false) {
            findViewById<Button>(R.id.buttonChance).visibility = View.INVISIBLE
        }else{
            findViewById<Button>(R.id.buttonChance).visibility = View.VISIBLE
        }
        if(currentPlayer.scoreSheet[16].visible == false) {
            findViewById<Button>(R.id.buttonYatzy).visibility = View.INVISIBLE
        }else{
            findViewById<Button>(R.id.buttonYatzy).visibility = View.VISIBLE
        }

        findViewById<TextView>(R.id.onesTextView).visibility = View.VISIBLE
        findViewById<TextView>(R.id.twosTextView).visibility = View.VISIBLE
        findViewById<TextView>(R.id.threesTextView).visibility = View.VISIBLE
        findViewById<TextView>(R.id.foursTextView).visibility = View.VISIBLE
        findViewById<TextView>(R.id.fivesTextView).visibility = View.VISIBLE
        findViewById<TextView>(R.id.sixesTextView).visibility = View.VISIBLE
        findViewById<TextView>(R.id.onePairTextView).visibility = View.VISIBLE
        findViewById<TextView>(R.id.twoPairsTextView).visibility = View.VISIBLE
        findViewById<TextView>(R.id.tripsTextView).visibility = View.VISIBLE
        findViewById<TextView>(R.id.fourOfAKindTextView).visibility = View.VISIBLE
        findViewById<TextView>(R.id.fullHouseTextView).visibility = View.VISIBLE
        findViewById<TextView>(R.id.chanceTextView).visibility = View.VISIBLE
        findViewById<TextView>(R.id.yatzyTextView).visibility = View.VISIBLE
        findViewById<TextView>(R.id.smStraightTextView).visibility = View.VISIBLE
        findViewById<TextView>(R.id.lgStraightTextView).visibility = View.VISIBLE

        findViewById<ImageView>(R.id.die1).visibility =View.VISIBLE
        findViewById<ImageView>(R.id.die2).visibility =View.VISIBLE
        findViewById<ImageView>(R.id.die3).visibility =View.VISIBLE
        findViewById<ImageView>(R.id.die4).visibility =View.VISIBLE
        findViewById<ImageView>(R.id.die5).visibility =View.VISIBLE

        findViewById<TextView>(R.id.selectTextView).visibility =View.VISIBLE
        findViewById<TextView>(R.id.desiredTextView).visibility = View.VISIBLE
    }

        //Hides mostly everything. For when waiting for a new player to roll.
    fun hideStuff(){
            findViewById<Button>(R.id.buttonOnes).visibility = View.INVISIBLE
            findViewById<Button>(R.id.buttonTwos).visibility = View.INVISIBLE
            findViewById<Button>(R.id.buttonTwos).visibility = View.INVISIBLE
            findViewById<Button>(R.id.buttonThrees).visibility = View.INVISIBLE
            findViewById<Button>(R.id.buttonThrees).visibility = View.INVISIBLE
            findViewById<Button>(R.id.buttonFours).visibility = View.INVISIBLE
            findViewById<Button>(R.id.buttonFours).visibility = View.INVISIBLE
            findViewById<Button>(R.id.buttonFives).visibility = View.INVISIBLE
            findViewById<Button>(R.id.buttonFives).visibility = View.INVISIBLE
            findViewById<Button>(R.id.buttonSixes).visibility = View.INVISIBLE
            findViewById<Button>(R.id.buttonSixes).visibility = View.INVISIBLE
            findViewById<Button>(R.id.buttonOnePair).visibility = View.INVISIBLE
            findViewById<Button>(R.id.buttonOnePair).visibility = View.INVISIBLE
            findViewById<Button>(R.id.buttonTwoPairs).visibility = View.INVISIBLE
            findViewById<Button>(R.id.buttonTwoPairs).visibility = View.INVISIBLE
            findViewById<Button>(R.id.buttonTrips).visibility = View.INVISIBLE
            findViewById<Button>(R.id.buttonTrips).visibility = View.INVISIBLE
            findViewById<Button>(R.id.buttonFourOfAKind).visibility = View.INVISIBLE
            findViewById<Button>(R.id.buttonFourOfAKind).visibility = View.INVISIBLE
            findViewById<Button>(R.id.buttonFullHouse).visibility = View.INVISIBLE
            findViewById<Button>(R.id.buttonFullHouse).visibility = View.INVISIBLE
            findViewById<Button>(R.id.buttonSmallStraight).visibility = View.INVISIBLE
            findViewById<Button>(R.id.buttonSmallStraight).visibility = View.INVISIBLE
            findViewById<Button>(R.id.buttonLargeStraight).visibility = View.INVISIBLE
            findViewById<Button>(R.id.buttonLargeStraight).visibility = View.INVISIBLE
            findViewById<Button>(R.id.buttonChance).visibility = View.INVISIBLE
            findViewById<Button>(R.id.buttonChance).visibility = View.INVISIBLE
            findViewById<Button>(R.id.buttonYatzy).visibility = View.INVISIBLE
            findViewById<Button>(R.id.buttonYatzy).visibility = View.INVISIBLE

            findViewById<TextView>(R.id.onesTextView).visibility = View.INVISIBLE
            findViewById<TextView>(R.id.twosTextView).visibility = View.INVISIBLE
            findViewById<TextView>(R.id.threesTextView).visibility = View.INVISIBLE
            findViewById<TextView>(R.id.foursTextView).visibility = View.INVISIBLE
            findViewById<TextView>(R.id.fivesTextView).visibility = View.INVISIBLE
            findViewById<TextView>(R.id.sixesTextView).visibility = View.INVISIBLE
            findViewById<TextView>(R.id.onePairTextView).visibility = View.INVISIBLE
            findViewById<TextView>(R.id.twoPairsTextView).visibility = View.INVISIBLE
            findViewById<TextView>(R.id.tripsTextView).visibility = View.INVISIBLE
            findViewById<TextView>(R.id.fourOfAKindTextView).visibility = View.INVISIBLE
            findViewById<TextView>(R.id.fullHouseTextView).visibility = View.INVISIBLE
            findViewById<TextView>(R.id.chanceTextView).visibility = View.INVISIBLE
            findViewById<TextView>(R.id.yatzyTextView).visibility = View.INVISIBLE
            findViewById<TextView>(R.id.smStraightTextView).visibility = View.INVISIBLE
            findViewById<TextView>(R.id.lgStraightTextView).visibility = View.INVISIBLE

            findViewById<ImageView>(R.id.die1).visibility =View.INVISIBLE
            findViewById<ImageView>(R.id.die2).visibility =View.INVISIBLE
            findViewById<ImageView>(R.id.die3).visibility =View.INVISIBLE
            findViewById<ImageView>(R.id.die4).visibility =View.INVISIBLE
            findViewById<ImageView>(R.id.die5).visibility =View.INVISIBLE

            findViewById<TextView>(R.id.selectTextView).visibility =View.INVISIBLE
            findViewById<TextView>(R.id.desiredTextView).visibility = View.INVISIBLE
        }

        //Summarizes every player's bonus and score
    fun sumPoints(){
        for(player in listOfPlayers){
            player.scoreSheet[6].points = player.scoreSheet[0].points+player.scoreSheet[1].points+
            player.scoreSheet[2].points+player.scoreSheet[3].points+player.scoreSheet[4].points+player.scoreSheet[5].points
        }
        for(player in listOfPlayers){
            if(player.scoreSheet[6].points >= 63){
                player.scoreSheet[7].points = 50
            }
        }
        for(player in listOfPlayers){
            player.scoreSheet[17].points = player.scoreSheet[6].points+player.scoreSheet[7].points+
            player.scoreSheet[8].points+player.scoreSheet[9].points+player.scoreSheet[10].points+
            player.scoreSheet[11].points+player.scoreSheet[12].points+player.scoreSheet[13].points+
            player.scoreSheet[14].points+player.scoreSheet[15].points+player.scoreSheet[16].points
        }
    }

        //starts scoreboard activity and passes along names and scores
    fun startScoreboardActivity()   {
        sumPoints()
        var scoreboardList :ArrayList<String> = arrayListOf()
        for(player in listOfPlayers){
            scoreboardList.add(player.name)
            scoreboardList.add(player.scoreSheet[17].points.toString())
        }
        val intent = Intent(this, ScoreboardActivity::class.java)
        intent.putStringArrayListExtra("scoreboardList", scoreboardList)
        startActivity(intent)

    }


        //Rolls dice and sets correct images
    fun rollDice(view: View){
        Log.d("!!!", "testing")
        if (currentPlayer!!.rolls == 3){
            for(die in currentPlayer.listOfDice)
                die.toBeRolled = true
        }
        if(currentPlayer!!.rolls > 0){
            for(die in currentPlayer.listOfDice) {
                if (die.toBeRolled == true) {
                    die.currentValue =  (1..6).random()
                    die.toBeRolled = false
                }
            }
            currentPlayer.rolls -= 1
        }

        setDiceImages()
        showHideButtons()
        showPlayerPoints()
    }

        //Sets a correct die image according to value
    fun setDieImage(die : Die, dieView: ImageView){
            when(die.currentValue){
            1 -> dieView.setImageResource(R.drawable.die1)
            2 -> dieView.setImageResource(R.drawable.die2)
            3 -> dieView.setImageResource(R.drawable.die3)
            4 -> dieView.setImageResource(R.drawable.die4)
            5 -> dieView.setImageResource(R.drawable.die5)
            6 -> dieView.setImageResource(R.drawable.die6)
        }
    }

        //Uses setDieImage to set the right die images
    fun setDiceImages(){
        setDieImage(currentPlayer.listOfDice[0], listOfDieImageViews[0])
        setDieImage(currentPlayer.listOfDice[1], listOfDieImageViews[1])
        setDieImage(currentPlayer.listOfDice[2], listOfDieImageViews[2])
        setDieImage(currentPlayer.listOfDice[3], listOfDieImageViews[3])
        setDieImage(currentPlayer.listOfDice[4], listOfDieImageViews[4])
    }

        //Sets the selected/red image for selected dice
    fun selectDie1(view: View){
        when(currentPlayer.listOfDice[0].toBeRolled) {
            false -> {when (currentPlayer.listOfDice[0].currentValue) {
                1 -> listOfDieImageViews[0].setImageResource(R.drawable.die1selected)
                2 -> listOfDieImageViews[0].setImageResource(R.drawable.die2selected)
                3 -> listOfDieImageViews[0].setImageResource(R.drawable.die3selected)
                4 -> listOfDieImageViews[0].setImageResource(R.drawable.die4selected)
                5 -> listOfDieImageViews[0].setImageResource(R.drawable.die5selected)
                6 -> listOfDieImageViews[0].setImageResource(R.drawable.die6selected)
            }
                currentPlayer.listOfDice [0].toBeRolled = true}

            true -> {when (currentPlayer.listOfDice[0].currentValue) {
                1 -> listOfDieImageViews[0].setImageResource(R.drawable.die1)
                2 -> listOfDieImageViews[0].setImageResource(R.drawable.die2)
                3 -> listOfDieImageViews[0].setImageResource(R.drawable.die3)
                4 -> listOfDieImageViews[0].setImageResource(R.drawable.die4)
                5 -> listOfDieImageViews[0].setImageResource(R.drawable.die5)
                6 -> listOfDieImageViews[0].setImageResource(R.drawable.die6)
            }
                currentPlayer.listOfDice [0].toBeRolled = false}
        }
    }

    fun selectDie2(view: View){
        when(currentPlayer.listOfDice[1].toBeRolled) {
            false -> {when (currentPlayer.listOfDice[1].currentValue) {
                1 -> listOfDieImageViews[1].setImageResource(R.drawable.die1selected)
                2 -> listOfDieImageViews[1].setImageResource(R.drawable.die2selected)
                3 -> listOfDieImageViews[1].setImageResource(R.drawable.die3selected)
                4 -> listOfDieImageViews[1].setImageResource(R.drawable.die4selected)
                5 -> listOfDieImageViews[1].setImageResource(R.drawable.die5selected)
                6 -> listOfDieImageViews[1].setImageResource(R.drawable.die6selected)
            }
                currentPlayer.listOfDice [1].toBeRolled = true}

            true -> {when (currentPlayer.listOfDice[1].currentValue) {
                1 -> listOfDieImageViews[1].setImageResource(R.drawable.die1)
                2 -> listOfDieImageViews[1].setImageResource(R.drawable.die2)
                3 -> listOfDieImageViews[1].setImageResource(R.drawable.die3)
                4 -> listOfDieImageViews[1].setImageResource(R.drawable.die4)
                5 -> listOfDieImageViews[1].setImageResource(R.drawable.die5)
                6 -> listOfDieImageViews[1].setImageResource(R.drawable.die6)
            }
                currentPlayer.listOfDice [1].toBeRolled = false}
        }
    }

    fun selectDie3(view: View){
        when(currentPlayer.listOfDice[2].toBeRolled) {
            false -> {when (currentPlayer.listOfDice[2].currentValue) {
                1 -> listOfDieImageViews[2].setImageResource(R.drawable.die1selected)
                2 -> listOfDieImageViews[2].setImageResource(R.drawable.die2selected)
                3 -> listOfDieImageViews[2].setImageResource(R.drawable.die3selected)
                4 -> listOfDieImageViews[2].setImageResource(R.drawable.die4selected)
                5 -> listOfDieImageViews[2].setImageResource(R.drawable.die5selected)
                6 -> listOfDieImageViews[2].setImageResource(R.drawable.die6selected)
            }
                currentPlayer.listOfDice [2].toBeRolled = true}

            true -> {when (currentPlayer.listOfDice[2].currentValue) {
                1 -> listOfDieImageViews[2].setImageResource(R.drawable.die1)
                2 -> listOfDieImageViews[2].setImageResource(R.drawable.die2)
                3 -> listOfDieImageViews[2].setImageResource(R.drawable.die3)
                4 -> listOfDieImageViews[2].setImageResource(R.drawable.die4)
                5 -> listOfDieImageViews[2].setImageResource(R.drawable.die5)
                6 -> listOfDieImageViews[2].setImageResource(R.drawable.die6)
            }
                currentPlayer.listOfDice [2].toBeRolled = false}
        }
    }

    fun selectDie4(view: View){
        when(currentPlayer.listOfDice[3].toBeRolled) {
            false -> {when (currentPlayer.listOfDice[3].currentValue) {
                1 -> listOfDieImageViews[3].setImageResource(R.drawable.die1selected)
                2 -> listOfDieImageViews[3].setImageResource(R.drawable.die2selected)
                3 -> listOfDieImageViews[3].setImageResource(R.drawable.die3selected)
                4 -> listOfDieImageViews[3].setImageResource(R.drawable.die4selected)
                5 -> listOfDieImageViews[3].setImageResource(R.drawable.die5selected)
                6 -> listOfDieImageViews[3].setImageResource(R.drawable.die6selected)
            }
                currentPlayer.listOfDice [3].toBeRolled = true}

            true -> {when (currentPlayer.listOfDice[3].currentValue) {
                1 -> listOfDieImageViews[3].setImageResource(R.drawable.die1)
                2 -> listOfDieImageViews[3].setImageResource(R.drawable.die2)
                3 -> listOfDieImageViews[3].setImageResource(R.drawable.die3)
                4 -> listOfDieImageViews[3].setImageResource(R.drawable.die4)
                5 -> listOfDieImageViews[3].setImageResource(R.drawable.die5)
                6 -> listOfDieImageViews[3].setImageResource(R.drawable.die6)
            }
                currentPlayer.listOfDice [3].toBeRolled = false}
        }
    }

    fun selectDie5(view: View){
        when(currentPlayer.listOfDice[4].toBeRolled) {
            false -> {when (currentPlayer.listOfDice[4].currentValue) {
                1 -> listOfDieImageViews[4].setImageResource(R.drawable.die1selected)
                2 -> listOfDieImageViews[4].setImageResource(R.drawable.die2selected)
                3 -> listOfDieImageViews[4].setImageResource(R.drawable.die3selected)
                4 -> listOfDieImageViews[4].setImageResource(R.drawable.die4selected)
                5 -> listOfDieImageViews[4].setImageResource(R.drawable.die5selected)
                6 -> listOfDieImageViews[4].setImageResource(R.drawable.die6selected)
            }
                currentPlayer.listOfDice [4].toBeRolled = true}

            true -> {when (currentPlayer.listOfDice[4].currentValue) {
                1 -> listOfDieImageViews[4].setImageResource(R.drawable.die1)
                2 -> listOfDieImageViews[4].setImageResource(R.drawable.die2)
                3 -> listOfDieImageViews[4].setImageResource(R.drawable.die3)
                4 -> listOfDieImageViews[4].setImageResource(R.drawable.die4)
                5 -> listOfDieImageViews[4].setImageResource(R.drawable.die5)
                6 -> listOfDieImageViews[4].setImageResource(R.drawable.die6)
            }
                currentPlayer.listOfDice [4].toBeRolled = false}
        }
    }

        //Methods to call points setters
    fun saveOnes(view: View){
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
    }
}