package com.example.farmersmarket.marketDB

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface MarketDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: MarketEntity)

    @Delete
    suspend fun delete(item: MarketEntity)

    @Query("SELECT * FROM products_table ORDER BY productId ASC")
    fun getAllProducts(): LiveData<List<MarketEntity>>
}