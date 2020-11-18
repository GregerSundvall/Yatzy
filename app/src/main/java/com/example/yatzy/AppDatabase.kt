package com.example.yatzy

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Highscore::class), version = 1)
abstract class AppDatabase : RoomDatabase()
{
    abstract fun highscoreDao(): HighscoreDao
}