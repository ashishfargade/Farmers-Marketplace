package com.example.farmersmarket.buyerMarket

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.farmersmarket.marketDB.MarketRepository

class BuyerViewModel(private val repository: MarketRepository, application: Application)
    : AndroidViewModel(application) {

        fun getAllMarketItems() = repository.allMarketItems()
}