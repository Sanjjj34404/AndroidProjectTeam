package com.threeandoiddev.racipeapp

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Recipe::class], exportSchema = false, version = 2)
abstract class AppDatabase :RoomDatabase(){
    abstract fun getDao(): Dao
}