package com.example.yatzy

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView

class ScoreRecyclerAdapter (val context: Context, )
    :RecyclerView.Adapter<ScoreRecyclerAdapter.ViewHolder>(){

    val layoutInflater = LayoutInflater.from((context))


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = layoutInflater.inflate(R.layout.list_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var score = ObjectManager.currentPlayer.scoreSheet[position]
        holder.pointsTextView.text = score.points.toString()
        holder.nameTextView.text = score.name
        holder.scorePosition = position

        if(ObjectManager.currentPlayer.scoreSheet[position].filled == true){
            holder.saveTextView.visibility = View.INVISIBLE
        }else{
            holder.saveTextView.visibility = View.VISIBLE
        }
    }

    override fun getItemCount(): Int {
        return ObjectManager.currentPlayer.scoreSheet.size
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val nameTextView = itemView.findViewById<TextView>(R.id.nameTextView)
        val saveTextView = itemView.findViewById<TextView>(R.id.saveTextView)
        val pointsTextView = itemView.findViewById<TextView>(R.id.pointsTextView)
        var scorePosition = 0

        init {

            saveTextView.setOnClickListener{
                if(ObjectManager.currentPlayer.rolls == 3){
                    Toast.makeText(context, "Roll dice first!", Toast.LENGTH_SHORT).show()
                }else if(ObjectManager.currentPlayer.alreadySaved == false) {
                    ObjectManager.currentPlayer.scoreSheet[scorePosition].saveScore(ObjectManager.currentPlayer)
                    ObjectManager.currentPlayer.alreadySaved = true
                    notifyDataSetChanged()
                }else{
                    Toast.makeText(context, "You already saved!", Toast.LENGTH_SHORT).show()
                }
            }
        }


    }
}