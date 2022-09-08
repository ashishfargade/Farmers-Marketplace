package com.example.farmersmarket.sellerMarket

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.farmersmarket.marketDB.MarketRepository

@Suppress("uUNCHECKED_CAST")
class SellerViewModelFactory(private val repository: MarketRepository, private val application: Application)
    : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return SellerViewModel(repository, application) as T
    }
}