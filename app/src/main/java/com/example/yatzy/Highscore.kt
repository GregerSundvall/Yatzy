package com.example.yatzy

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = highscores)
class Highscore (
    @PrimaryKey(autoGenerate = true)    val id: Int,
    @ColumnInfo(name = "player")        var player: String,
    @ColumnInfo(name = "score")         var score: Int
)

