package com.example.farmersmarket.marketDB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [MarketEntity::class], version = 1)
abstract class MarketDatabase : RoomDatabase(){

    abstract fun getMarketDao() : MarketDao

    companion object{
        @Volatile
        private var instance: MarketDatabase?= null
        private val LOCK = Any()

        operator fun invoke(context: Context?) = instance?: synchronized(LOCK){
            instance?: createDatabase(context).also{
                instance = it
            }
        }

        private fun createDatabase(context: Context?) =
            Room.databaseBuilder(
                context!!.applicationContext,
                MarketDatabase::class.java, "MarketDatabase.db").build()
    }
}