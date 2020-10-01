package com.example.yatzy

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ScoreRecyclerAdapter (val context: Context, val recyclerScores : List<Score>)
    :RecyclerView.Adapter<ScoreRecyclerAdapter.ViewHolder>(){

    val layoutInflater = LayoutInflater.from((context))


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = layoutInflater.inflate(R.layout.list_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val score = recyclerScores[position]
        holder.pointsTextView.text = score.points.toString()
        holder.nameTextView.text = score.name
        holder.scorePosition = position

        if(recyclerScores[position].filled == true){
            holder.saveTextView.visibility = View.INVISIBLE
        }

    }

    override fun getItemCount(): Int {
        return recyclerScores.size
    }

    fun saveScore(scorePosition : Int){
        recyclerScores[0].saveScore()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val nameTextView = itemView.findViewById<TextView>(R.id.nameTextView)
        val saveTextView = itemView.findViewById<TextView>(R.id.saveTextView)
        val pointsTextView = itemView.findViewById<TextView>(R.id.pointsTextView)
        var scorePosition = 0

        init {
            saveTextView.setOnClickListener{
                saveScore(scorePosition)
            }
        }
    }
}