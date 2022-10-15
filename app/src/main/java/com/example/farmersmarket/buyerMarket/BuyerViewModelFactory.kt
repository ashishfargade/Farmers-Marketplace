package com.example.farmersmarket.buyerMarket

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.farmersmarket.marketDB.MarketRepository

@Suppress("UNCHECKED_CAST")
class BuyerViewModelFactory(private val repository: MarketRepository, private val application: Application)
    : ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return BuyerViewModel(repository, application) as T
    }
}