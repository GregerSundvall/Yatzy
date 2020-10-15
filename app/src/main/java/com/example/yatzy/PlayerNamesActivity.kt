package com.example.yatzy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_player_names.*

class PlayerNamesActivity : AppCompatActivity() {

    var nrOfplayers = 2
    val listOfNameBoxes = mutableListOf<EditText>()
    var noNameWarning = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player_names)

        nrOfplayers = intent.getIntExtra("nrOfPlayers", 2)
        hideUnnecessaryNameboxes()


    }

        //Makes unnecessary nameboxes disappear
    fun hideUnnecessaryNameboxes(){
        if(nrOfplayers <= 5){
            Player6NamePlainText.visibility = View.GONE
            if(nrOfplayers <= 4){
                Player5NamePlainText.visibility = View.GONE
                if(nrOfplayers <= 3){
                    Player4NamePlainText.visibility = View.GONE
                    if(nrOfplayers <= 2){
                        Player3NamePlainText.visibility = View.GONE
                        if(nrOfplayers <= 1){
                            Player2NamePlainText.visibility = View.GONE
                        }
                    }
                }
            }
        }
    }

    fun createPlayers(){
        ObjectManager.listOfPlayers.add(Player("${Player1NamePlainText.text}"))
        if (nrOfplayers >= 2) {
            ObjectManager.listOfPlayers.add(Player("${Player2NamePlainText.text}"))

            if (nrOfplayers >= 3) {
                ObjectManager.listOfPlayers.add(Player("${Player3NamePlainText.text}"))

                if (nrOfplayers >= 4) {
                    ObjectManager.listOfPlayers.add(Player("${Player4NamePlainText.text}"))

                    if (nrOfplayers >= 5) {
                        ObjectManager.listOfPlayers.add(Player("${Player5NamePlainText.text}"))

                        if (nrOfplayers == 6) {
                            ObjectManager.listOfPlayers.add(Player("${Player6NamePlainText.text}"))
                        }
                    }
                }
            }
        }
    }

    fun checkPlayerNames(){
        listOfNameBoxes.add(findViewById(R.id.Player1NamePlainText))
        if(nrOfplayers >= 2 ){
            listOfNameBoxes.add(findViewById(R.id.Player2NamePlainText))
            if(nrOfplayers >= 3 ) {
                listOfNameBoxes.add(findViewById(R.id.Player3NamePlainText))
                if(nrOfplayers >= 4 ) {
                    listOfNameBoxes.add(findViewById(R.id.Player4NamePlainText))
                    if(nrOfplayers >= 5 ) {
                        listOfNameBoxes.add(findViewById(R.id.Player5NamePlainText))
                        if(nrOfplayers >= 6 ) {
                            listOfNameBoxes.add(findViewById(R.id.Player6NamePlainText))
                        }
                    }
                }
            }
        }

        for(nameBox in listOfNameBoxes){
            if(nameBox.text.length < 1){
                noNameWarning = true
            }
        }
    }
    fun startGamePlayActivity(view : View){
        noNameWarning = false
        checkPlayerNames()
        if(noNameWarning == false){
            createPlayers()
            ObjectManager.currentPlayer = ObjectManager.listOfPlayers.first()
            val intent = Intent(this, GamePlayActivity::class.java)
            startActivity(intent)
        }else{
            Toast.makeText(this, "${getString(R.string.noNameWarning)}",
                Toast.LENGTH_SHORT).show()
        }
    }
}