package com.example.yatzy

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class TopTenFragment : Fragment(), CoroutineScope{

    private lateinit var job: Job
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job
    private lateinit var db: AppDatabase
    var topTen = mutableListOf<Highscore>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        job= Job()
        db = AppDatabase.getInstance(activity!!.applicationContext)

        getTopTenFromRoom()





        return inflater.inflate(R.layout.fragment_top_ten, container, false)
    }

    fun getTopTenFromRoom(){
        var deferredList = async(Dispatchers.IO) {
            db.highscoreDao.getTopTen()
        }
        launch{
            topTen = deferredList.await().toMutableList()
            Log.d("!!!", topTen[0].player)
            showTopTen(topTen)
        }
    }

    fun showTopTen(topTen : MutableList<Highscore>){
        view?.findViewById<TextView>(R.id.topTen1stNameTextView)?.text =
            topTen[0].player
        view?.findViewById<TextView>(R.id.topTen1stScoreTextView)?.text =
            topTen[0].score.toString()
        view?.findViewById<TextView>(R.id.topTen2ndNameTextView)?.text =
            topTen[1].player
        view?.findViewById<TextView>(R.id.topTen2ndScoreTextView)?.text =
            topTen[1].score.toString()
        view?.findViewById<TextView>(R.id.topTen3rdNameTextView)?.text =
            topTen[2].player
        view?.findViewById<TextView>(R.id.topTen3rdScoreTextView)?.text =
            topTen[2].score.toString()
        view?.findViewById<TextView>(R.id.topTen4thNameTextView)?.text =
            topTen[3].player
        view?.findViewById<TextView>(R.id.topTen4thScoreTextView)?.text =
            topTen[3].score.toString()
        view?.findViewById<TextView>(R.id.topTen5thNameTextView)?.text =
            topTen[4].player
        view?.findViewById<TextView>(R.id.topTen5thScoreTextView)?.text =
            topTen[4].score.toString()
        view?.findViewById<TextView>(R.id.topTen6thNameTextView)?.text =
            topTen[5].player
        view?.findViewById<TextView>(R.id.topTen6thScoreTextView)?.text =
            topTen[5].score.toString()
        view?.findViewById<TextView>(R.id.topTen7thNameTextView)?.text =
            topTen[6].player
        view?.findViewById<TextView>(R.id.topTen7thScoreTextView)?.text =
            topTen[6].score.toString()
        view?.findViewById<TextView>(R.id.topTen8thNameTextView)?.text =
            topTen[7].player
        view?.findViewById<TextView>(R.id.topTen8thScoreTextView)?.text =
            topTen[7].score.toString()
        view?.findViewById<TextView>(R.id.topTen9thNameTextView)?.text =
            topTen[8].player
        view?.findViewById<TextView>(R.id.topTen9thScoreTextView)?.text =
            topTen[8].score.toString()
        view?.findViewById<TextView>(R.id.topTen10thNameTextView)?.text =
            topTen[9].player
        view?.findViewById<TextView>(R.id.topTen10thScoreTextView)?.text =
            topTen[9].score.toString()
    }



    override fun onDestroy() {
        job.cancel()
        super.onDestroy()
    }
}