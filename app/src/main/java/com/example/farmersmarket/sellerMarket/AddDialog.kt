package com.example.farmersmarket.sellerMarket

import android.content.Context
import android.os.Bundle
import android.view.Window
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.example.farmersmarket.R
import com.example.farmersmarket.marketDB.MarketEntity
import kotlinx.android.synthetic.main.add_dialog.*

class AddDialog(context: Context, var addDialogListener: AddDialogListener) :
    AppCompatDialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.add_dialog)

        idBtnAdd.setOnClickListener {
            val name = idETItemName.text.toString()
            val quantity = idETItemQuantity.text.toString().toInt()
            val price = idETItemPrice.text.toString().toInt()
            if(name.isNullOrEmpty()) {
                Toast.makeText(context, "Please enter a name", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val item = MarketEntity(name, quantity, price)
            addDialogListener.onAddButtonClicked(item)
            dismiss()
        }

        idBtnCancel.setOnClickListener {
            cancel()
        }
    }
}