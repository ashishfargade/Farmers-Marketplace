package com.example.farmersmarket.sellerMarket

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.farmersmarket.marketDB.MarketEntity
import com.example.farmersmarket.marketDB.MarketRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class SellerViewModel(private val repository: MarketRepository, application: Application):
    AndroidViewModel(application) {

    fun insert(item: MarketEntity) = GlobalScope.launch {
        repository.insert(item)
    }

    fun delete(item: MarketEntity) = GlobalScope.launch {
        repository.delete(item)
    }

    fun getAllMarketItems() = repository.allMarketItems()
}