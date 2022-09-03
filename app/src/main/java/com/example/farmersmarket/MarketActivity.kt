package com.example.farmersmarket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.farmersmarket.buyerMarket.BuyerFragment
import com.example.farmersmarket.databinding.ActivityMarketBinding
import com.example.farmersmarket.sellerMarket.SellerFragment
import kotlinx.android.synthetic.main.activity_market.*

class MarketActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMarketBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_market)
        replaceFragment(SellerFragment())

        binding.bottomNavigationView.setOnNavigationItemSelectedListener {

            when(it.itemId){
                R.id.ic_seller -> replaceFragment(SellerFragment())
                R.id.ic_buyer -> replaceFragment(BuyerFragment())
                R.id.ic_info -> replaceFragment(SellerFragment())
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainerView2, fragment)
        fragmentTransaction.commit()
    }

}