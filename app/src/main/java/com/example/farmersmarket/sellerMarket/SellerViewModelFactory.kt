package com.example.farmersmarket.sellerMarket

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.farmersmarket.marketDB.MarketRepository

class SellerViewModelFactory(private val repository: MarketRepository): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SellerViewModel(repository) as T
    }
}