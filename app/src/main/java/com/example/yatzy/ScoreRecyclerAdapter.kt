package com.example.yatzy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ScoreRecyclerAdapter (val context: GamePlayActivity, )
    :RecyclerView.Adapter<ScoreRecyclerAdapter.ViewHolder>(){

    val layoutInflater = LayoutInflater.from((context))
    var listOfScoreNames = mutableListOf<String>()
    var lastSavedScorePosition = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = layoutInflater.inflate(R.layout.list_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val score = ObjectManager.currentPlayer.scoreSheet[position]
        holder.pointsTextView.text = score.points.toString()
        holder.scoreNameTextView.text = listOfScoreNames[position]
        holder.scorePosition = position
        if(ObjectManager.currentPlayer.scoreSheet[position].saved == true){
            holder.saveTextView.visibility = View.INVISIBLE
        }else{
            holder.saveTextView.visibility = View.VISIBLE
        }
    }

    override fun getItemCount(): Int {
        return ObjectManager.currentPlayer.scoreSheet.size-3
    }

    fun revertLastSave(){
        ObjectManager.currentPlayer.scoreSheet[lastSavedScorePosition].points = 0
        ObjectManager.currentPlayer.scoreSheet[lastSavedScorePosition].saved = false
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val scoreNameTextView = itemView.findViewById<TextView>(R.id.scoreNameTextView)
        val saveTextView = itemView.findViewById<TextView>(R.id.saveTextView)
        val pointsTextView = itemView.findViewById<TextView>(R.id.pointsTextView)
        var scorePosition = 0

        init {
            populateListOfScoreNames()
            saveTextView.setOnClickListener{
                if(ObjectManager.currentPlayer.rolls == 3) {
                    Toast.makeText(
                        context, "${context.getString(R.string.rollDiceFirst)}",
                        Toast.LENGTH_SHORT
                    ).show()
                }else{
                    if(ObjectManager.currentPlayer.alreadySaved == true){
                        revertLastSave()
                    }
                    ObjectManager.currentPlayer.scoreSheet[scorePosition].saveScore(ObjectManager.currentPlayer)
                    ObjectManager.currentPlayer.alreadySaved = true
                    notifyDataSetChanged()
                    context.hideTapToSelect()
                    lastSavedScorePosition = scorePosition
                }
            }
        }
    }
        //fills list of score names from localized strings
    fun populateListOfScoreNames(){
        listOfScoreNames.add(context.getString(R.string.ones))
        listOfScoreNames.add(context.getString(R.string.twos))
        listOfScoreNames.add(context.getString(R.string.threes))
        listOfScoreNames.add(context.getString(R.string.fours))
        listOfScoreNames.add(context.getString(R.string.fives))
        listOfScoreNames.add(context.getString(R.string.sixes))
        listOfScoreNames.add(context.getString(R.string.onePair))
        listOfScoreNames.add(context.getString(R.string.twoPairs))
        listOfScoreNames.add(context.getString(R.string.threeOfAKind))
        listOfScoreNames.add(context.getString(R.string.fourOfAKind))
        listOfScoreNames.add(context.getString(R.string.fullHouse))
        listOfScoreNames.add(context.getString(R.string.smallStraight))
        listOfScoreNames.add(context.getString(R.string.largeStraight))
        listOfScoreNames.add(context.getString(R.string.chance))
        listOfScoreNames.add(context.getString(R.string.yatzy))
    }
}