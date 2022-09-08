package com.example.farmersmarket.sellerMarket

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.farmersmarket.marketDB.MarketEntity
import com.example.farmersmarket.marketDB.MarketRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*

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