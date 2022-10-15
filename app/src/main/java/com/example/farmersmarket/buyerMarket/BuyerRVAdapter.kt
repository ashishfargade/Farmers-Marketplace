package com.example.farmersmarket.buyerMarket

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.farmersmarket.R
import com.example.farmersmarket.marketDB.MarketEntity
import kotlinx.android.synthetic.main.product_rv_item.view.idTVItemName
import kotlinx.android.synthetic.main.product_rv_item.view.idTVQuantity
import kotlinx.android.synthetic.main.product_rv_item.view.idTVRate
import kotlinx.android.synthetic.main.product_rv_item2.view.*

class BuyerRVAdapter(
    var items: List<MarketEntity>,
    private val viewModel: BuyerViewModel
): RecyclerView.Adapter<BuyerRVAdapter.BuyerViewHolder>() {

    inner class BuyerViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BuyerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_rv_item2, parent, false)
        return BuyerViewHolder(view)
    }

    override fun onBindViewHolder(holder: BuyerViewHolder, position: Int) {
        val currentItem = items[position]
        holder.itemView.idTVItemName.text = currentItem.itemName
        holder.itemView.idTVQuantity.text = currentItem.itemQuantity.toString()
        holder.itemView.idTVRate.text = currentItem.itemPrice.toString()

        holder.itemView.idIVAddToCart.setOnClickListener {
            TODO("IMPLEMENT ADD TO CART")
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}