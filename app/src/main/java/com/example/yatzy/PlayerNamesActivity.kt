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

        //var player1name :View = findViewById(R.id.Player1NamePlainText)
        //var player2name :View = findViewById(R.id.Player2NamePlainText)
        var player3name :View = findViewById(R.id.Player3NamePlainText)
        var player4name :View = findViewById(R.id.Player4NamePlainText)
        var player5name :View = findViewById(R.id.Player5NamePlainText)
        var player6name :View = findViewById(R.id.Player6NamePlainText)

        when(nrOfplayers){
            2 ->    {player3name.visibility = View.GONE
                    player4name.visibility = View.GONE
                    player5name.visibility = View.GONE
                    player6name.visibility = View.GONE
            }

            3 ->    {player4name.visibility = View.GONE
                    player5name.visibility = View.GONE
                    player6name.visibility = View.GONE
            }

            4 ->    {player5name.visibility = View.GONE
                    player6name.visibility = View.GONE
            }

            5 ->    {player6name.visibility = View.GONE
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