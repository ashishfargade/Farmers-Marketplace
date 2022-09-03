package com.example.farmersmarket.sellerMarket

import androidx.lifecycle.ViewModel
import com.example.farmersmarket.marketDB.MarketEntity
import com.example.farmersmarket.marketDB.MarketRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class SellerViewModel(private val repository: MarketRepository): ViewModel() {

    fun insert(item: MarketEntity) = GlobalScope.launch {
        repository.insert(item)
    }

    fun delete(item: MarketEntity) = GlobalScope.launch {
        repository.delete(item)
    }

    fun getAllMarketItems() = repository.allMarketItems()
}