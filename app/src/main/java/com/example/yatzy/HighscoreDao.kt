package com.example.yatzy

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface HighscoreDao

{
    @Insert
    fun insert(highscore: Highscore)

    @Delete
    fun delete(highscore: Highscore)

    @Query("SELECT * FROM highscore")
    fun getAll(): List<Highscore>

    @Query("SELECT * FROM highscore WHERE score LIKE :categoryName")
    fun findByCategory(categoryName: String) : List<Highscore>



}