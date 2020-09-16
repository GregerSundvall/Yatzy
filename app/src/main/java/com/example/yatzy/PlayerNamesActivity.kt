package com.example.yatzy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_player_names.*

class PlayerNamesActivity : AppCompatActivity() {

    var nrOfplayers = 0
    val listOfPlayerNames :ArrayList<String> = arrayListOf()
    //val gSettings = Settings
    //val listofp = gSettings.listOfPlayers
    //singleton class

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player_names)

        nrOfplayers = intent.getIntExtra("nrOfPlayers", 2)

        when(nrOfplayers){
            2 ->    {Player3NamePlainText.visibility = View.GONE
                    Player4NamePlainText.visibility = View.GONE
                    Player5NamePlainText.visibility = View.GONE
                    Player6NamePlainText.visibility = View.GONE
            }

            3 ->    {Player4NamePlainText.visibility = View.GONE
                    Player5NamePlainText.visibility = View.GONE
                    Player6NamePlainText.visibility = View.GONE
            }

            4 ->    {Player5NamePlainText.visibility = View.GONE
                    Player6NamePlainText.visibility = View.GONE
            }

            5 ->    {Player6NamePlainText.visibility = View.GONE
            }
        }
    }

    fun startGamePlayActivity(v : View){
        listOfPlayerNames.add (Player1NamePlainText.text.toString())
        listOfPlayerNames.add (Player2NamePlainText.text.toString())

        if (nrOfplayers >= 3) {
            listOfPlayerNames.add(Player3NamePlainText.text.toString())

            if(nrOfplayers >= 4){
                listOfPlayerNames.add(Player4NamePlainText.text.toString())

                if(nrOfplayers >= 5){
                    listOfPlayerNames.add(Player5NamePlainText.text.toString())

                    if(nrOfplayers >= 6){
                        listOfPlayerNames.add(Player6NamePlainText.text.toString())
                    }
                }
            }

        }
        val intent = Intent(this, PrepareActivity::class.java)
        intent.putStringArrayListExtra("listOfPlayers", listOfPlayerNames)
        startActivity(intent)

    }
}