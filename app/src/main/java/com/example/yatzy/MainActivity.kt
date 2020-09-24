package com.example.yatzy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowInsetsController

class MainActivity : AppCompatActivity() {

    var nrOfPlayers :Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun start2(view:View){
        nrOfPlayers = 2
        startPlayerNamesActivity()
    }

    fun start3(view:View){
        nrOfPlayers = 3
        startPlayerNamesActivity()
    }

    fun start4(view:View){
        nrOfPlayers = 4
        startPlayerNamesActivity()
    }

    fun start5(view:View){
        nrOfPlayers = 5
        startPlayerNamesActivity()
    }

    fun start6(view:View){
        nrOfPlayers = 6
        startPlayerNamesActivity()
    }

    fun startPlayerNamesActivity()   {
        val intent = Intent(this, PlayerNamesActivity::class.java)
        intent.putExtra("nrOfPlayers", nrOfPlayers)
        startActivity(intent)
    }
}