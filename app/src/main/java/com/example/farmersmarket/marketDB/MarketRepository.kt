package com.example.farmersmarket.marketDB

class MarketRepository(private val dao: MarketDao){

    suspend fun insert(item: MarketEntity) = dao.insert(item)
    suspend fun delete(item: MarketEntity) = dao.delete(item)

    fun allMarketItems() = dao.getAllProducts()
}