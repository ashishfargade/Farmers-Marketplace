package com.example.farmersmarket.buyerMarket

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.farmersmarket.R
import com.example.farmersmarket.databinding.FragmentBuyerBinding


class BuyerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentBuyerBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_buyer, container,false)



    // Inflate the layout for this fragment
        return binding.root
    }

}