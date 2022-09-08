package com.example.farmersmarket.sellerMarket

import com.example.farmersmarket.marketDB.MarketEntity

interface AddDialogListener {
    fun onAddButtonClicked(item: MarketEntity)
}