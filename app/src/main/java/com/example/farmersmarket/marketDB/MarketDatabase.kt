package com.example.farmersmarket.marketDB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.farmersmarket.userDatabase.RegisterDatabase

@Database(entities = [MarketEntity::class], version = 1)
abstract class MarketDatabase : RoomDatabase(){

    abstract fun getMarketDao() : MarketDao

    companion object{
        @Volatile
        private var INSTANCE: MarketDatabase?= null

        fun getInstance(context: Context): MarketDatabase {
            synchronized(this) {

                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        MarketDatabase::class.java,
                        "market_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()

                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}