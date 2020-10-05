package com.example.yatzy

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.example.yatzy.Players.listOfPlayers

class ScoreRecyclerAdapter (val context: Context, val recyclerPlayer : Player)
    :RecyclerView.Adapter<ScoreRecyclerAdapter.ViewHolder>(){

    val layoutInflater = LayoutInflater.from((context))


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = layoutInflater.inflate(R.layout.list_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val score = recyclerPlayer.scoreSheet[position]
        holder.pointsTextView.text = score.points.toString()
        holder.nameTextView.text = score.name
        holder.scorePosition = position

        if(recyclerPlayer.scoreSheet[position].filled == true){
            holder.saveTextView.visibility = View.INVISIBLE
        }
    }

    override fun getItemCount(): Int {
        return recyclerPlayer.scoreSheet.size
    }



    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val nameTextView = itemView.findViewById<TextView>(R.id.nameTextView)
        val saveTextView = itemView.findViewById<TextView>(R.id.saveTextView)
        val pointsTextView = itemView.findViewById<TextView>(R.id.pointsTextView)
        var scorePosition = 0

        init {

            saveTextView.setOnClickListener{
                if(recyclerPlayer.alreadySaved == false) {
                    recyclerPlayer.scoreSheet[scorePosition].saveScore(recyclerPlayer)
                    notifyDataSetChanged()
                    recyclerPlayer.alreadySaved = true
                    itemView.findViewById<TextView>(R.id.saveTextView).visibility = View.INVISIBLE
                }
            }
        }

    }
}