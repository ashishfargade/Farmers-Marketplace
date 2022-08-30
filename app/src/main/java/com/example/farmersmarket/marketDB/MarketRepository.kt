package com.example.farmersmarket.marketDB

class MarketRepository (private val db: MarketDatabase){

    suspend fun insert(item: MarketEntity) = db.getMarketDao().insert(item)
    suspend fun delete(item: MarketEntity) = db.getMarketDao().delete(item)

    fun allMarketItems() = db.getMarketDao().getAllProducts()
}