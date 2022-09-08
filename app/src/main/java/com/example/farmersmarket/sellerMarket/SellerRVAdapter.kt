package com.example.farmersmarket.sellerMarket

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.farmersmarket.R
import com.example.farmersmarket.marketDB.MarketEntity
import kotlinx.android.synthetic.main.product_rv_item.view.*

class SellerRVAdapter(
    var items: List<MarketEntity>,
    private val viewModel: SellerViewModel
) : RecyclerView.Adapter<SellerRVAdapter.SellerViewHolder>() {


    inner class SellerViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SellerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_rv_item, parent, false)
        return SellerViewHolder(view)
    }

    override fun onBindViewHolder(holder: SellerViewHolder, position: Int) {
        val currentItem = items[position]
        holder.itemView.idTVItemName.text = currentItem.itemName
        holder.itemView.idTVQuantity.text = currentItem.itemQuantity.toString()
        holder.itemView.idTVRate.text = currentItem.itemPrice.toString()

        holder.itemView.idIVDelete.setOnClickListener {
            viewModel.delete(currentItem)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}