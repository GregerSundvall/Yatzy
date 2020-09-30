package com.example.yatzy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class GamePlayActivity : AppCompatActivity() {

    val listOfPlayers = Players.listOfPlayers
    val listOfDieImageViews: MutableList<ImageView> = mutableListOf<ImageView>()
    var currentRound : Int = 0
    var currentPlayer = listOfPlayers.last()
    var listOfPointsBoxes = mutableListOf<TextView>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_play)

        createScoresheet()
        createDice()
        populateListOfDieImageViews()
        populateListOfPointsBoxes()
        newTurn()
    }

        //Starts next turn
    fun newTurn(){
        hideEverything()
        if(currentRound == 5 && currentPlayer == listOfPlayers.last()){
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
    }

    fun populateListOfPointsBoxes(){
        listOfPointsBoxes.add(findViewById<TextView>(R.id.onesTextView))
        listOfPointsBoxes.add(findViewById<TextView>(R.id.twosTextView))
        listOfPointsBoxes.add(findViewById<TextView>(R.id.threesTextView))
        listOfPointsBoxes.add(findViewById<TextView>(R.id.foursTextView))
        listOfPointsBoxes.add(findViewById<TextView>(R.id.fivesTextView))
        listOfPointsBoxes.add(findViewById<TextView>(R.id.sixesTextView))
        listOfPointsBoxes.add(findViewById<TextView>(R.id.onePairTextView))
        listOfPointsBoxes.add(findViewById<TextView>(R.id.twoPairsTextView))
        listOfPointsBoxes.add(findViewById<TextView>(R.id.tripsTextView))
        listOfPointsBoxes.add(findViewById<TextView>(R.id.fourOfAKindTextView))
        listOfPointsBoxes.add(findViewById<TextView>(R.id.fullHouseTextView))
        listOfPointsBoxes.add(findViewById<TextView>(R.id.chanceTextView))
        listOfPointsBoxes.add(findViewById<TextView>(R.id.yatzyTextView))
        listOfPointsBoxes.add(findViewById<TextView>(R.id.smStraightTextView))
        listOfPointsBoxes.add(findViewById<TextView>(R.id.lgStraightTextView))
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
        for (player in listOfPlayers) {
            for (i in 1..18){
                player.scoreSheet.add(Score())
            }
        }
    }

        //Shows correct points in points boxes
    fun showPlayerPoints(){
        listOfPointsBoxes[0].text = getString(R.string.onesPoints, currentPlayer.scoreSheet[0].points.toString())
        listOfPointsBoxes[1].text = getString(R.string.twosPoints, currentPlayer.scoreSheet[1].points.toString())
        listOfPointsBoxes[2].text = getString(R.string.threesPoints, currentPlayer.scoreSheet[2].points.toString())
        listOfPointsBoxes[3].text = getString(R.string.foursPoints, currentPlayer.scoreSheet[3].points.toString())
        listOfPointsBoxes[4].text = getString(R.string.fivesPoints, currentPlayer.scoreSheet[4].points.toString())
        listOfPointsBoxes[5].text = getString(R.string.sixesPoints, currentPlayer.scoreSheet[5].points.toString())
        listOfPointsBoxes[6].text = getString(R.string.onePairPoints, currentPlayer.scoreSheet[8].points.toString())
        listOfPointsBoxes[7].text = getString(R.string.twoPairsPoints, currentPlayer.scoreSheet[9].points.toString())
        listOfPointsBoxes[8].text = getString(R.string.tripsPoints, currentPlayer.scoreSheet[10].points.toString())
        listOfPointsBoxes[9].text = getString(R.string.fourOfAKindPoints, currentPlayer.scoreSheet[11].points.toString())
        listOfPointsBoxes[10].text = getString(R.string.fullHousePoints, currentPlayer.scoreSheet[12].points.toString())
        listOfPointsBoxes[11].text = getString(R.string.smStraightPoints, currentPlayer.scoreSheet[13].points.toString())
        listOfPointsBoxes[12].text = getString(R.string.lgStraightPoints, currentPlayer.scoreSheet[14].points.toString())
        listOfPointsBoxes[13].text = getString(R.string.chancePoints, currentPlayer.scoreSheet[15].points.toString())
        listOfPointsBoxes[14].text = getString(R.string.yatzyPoints, currentPlayer.scoreSheet[16].points.toString())

    }

        //shows a button if score is not used
    fun showAButton(score : Score , button : Button){
        if(score.visible == true){
            button.visibility = View.VISIBLE
        }
    }
        //shows a pointsbox if not zero
    fun showScoreIfDone(points : Int , textView : TextView){
        if(points != 0){
            textView.visibility = View.VISIBLE
        }
    }

        //Shows score buttons, textviews and dice according to visibility variable and usage
    fun showHideButtons(){
        showAButton(currentPlayer.scoreSheet[0], findViewById<Button>(R.id.buttonOnes))
        showAButton(currentPlayer.scoreSheet[1], findViewById<Button>(R.id.buttonTwos))
        showAButton(currentPlayer.scoreSheet[2], findViewById<Button>(R.id.buttonThrees))
        showAButton(currentPlayer.scoreSheet[3], findViewById<Button>(R.id.buttonFours))
        showAButton(currentPlayer.scoreSheet[4], findViewById<Button>(R.id.buttonFives))
        showAButton(currentPlayer.scoreSheet[5], findViewById<Button>(R.id.buttonSixes))
        showAButton(currentPlayer.scoreSheet[8], findViewById<Button>(R.id.buttonOnePair))
        showAButton(currentPlayer.scoreSheet[9], findViewById<Button>(R.id.buttonTwoPairs))
        showAButton(currentPlayer.scoreSheet[10], findViewById<Button>(R.id.buttonTrips))
        showAButton(currentPlayer.scoreSheet[11], findViewById<Button>(R.id.buttonFourOfAKind))
        showAButton(currentPlayer.scoreSheet[12], findViewById<Button>(R.id.buttonFullHouse))
        showAButton(currentPlayer.scoreSheet[13], findViewById<Button>(R.id.buttonSmallStraight))
        showAButton(currentPlayer.scoreSheet[14], findViewById<Button>(R.id.buttonLargeStraight))
        showAButton(currentPlayer.scoreSheet[15], findViewById<Button>(R.id.buttonChance))
        showAButton(currentPlayer.scoreSheet[16], findViewById<Button>(R.id.buttonYatzy))

        showScoreIfDone(currentPlayer.scoreSheet[0].points, listOfPointsBoxes[0])
        showScoreIfDone(currentPlayer.scoreSheet[1].points, listOfPointsBoxes[1])
        showScoreIfDone(currentPlayer.scoreSheet[2].points, listOfPointsBoxes[2])
        showScoreIfDone(currentPlayer.scoreSheet[3].points, listOfPointsBoxes[3])
        showScoreIfDone(currentPlayer.scoreSheet[4].points, listOfPointsBoxes[4])
        showScoreIfDone(currentPlayer.scoreSheet[5].points, listOfPointsBoxes[5])
        showScoreIfDone(currentPlayer.scoreSheet[8].points, listOfPointsBoxes[6])
        showScoreIfDone(currentPlayer.scoreSheet[9].points, listOfPointsBoxes[7])
        showScoreIfDone(currentPlayer.scoreSheet[10].points, listOfPointsBoxes[8])
        showScoreIfDone(currentPlayer.scoreSheet[11].points, listOfPointsBoxes[9])
        showScoreIfDone(currentPlayer.scoreSheet[12].points, listOfPointsBoxes[10])
        showScoreIfDone(currentPlayer.scoreSheet[13].points, listOfPointsBoxes[11])
        showScoreIfDone(currentPlayer.scoreSheet[14].points, listOfPointsBoxes[12])
        showScoreIfDone(currentPlayer.scoreSheet[15].points, listOfPointsBoxes[13])
        showScoreIfDone(currentPlayer.scoreSheet[16].points, listOfPointsBoxes[14])

        findViewById<ImageView>(R.id.die1).visibility =View.VISIBLE
        findViewById<ImageView>(R.id.die2).visibility =View.VISIBLE
        findViewById<ImageView>(R.id.die3).visibility =View.VISIBLE
        findViewById<ImageView>(R.id.die4).visibility =View.VISIBLE
        findViewById<ImageView>(R.id.die5).visibility =View.VISIBLE

        findViewById<TextView>(R.id.selectTextView).visibility =View.VISIBLE
        findViewById<TextView>(R.id.desiredTextView).visibility = View.VISIBLE
    }

        //Hides everything but roll button and textview with player name.
        //Used when waiting for a new player to roll.
    fun hideEverything(){
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
            for(die in currentPlayer.listOfDice)
                die.toBeRolled = true
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
        showHideButtons()
        showPlayerPoints()
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

        //Methods to call points setters and start next turn
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