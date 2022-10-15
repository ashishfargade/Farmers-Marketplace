package com.example.farmersmarket.buyerMarket

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.farmersmarket.R
import com.example.farmersmarket.databinding.FragmentBuyerBinding
import com.example.farmersmarket.marketDB.MarketDatabase
import com.example.farmersmarket.marketDB.MarketRepository


class BuyerFragment : Fragment() {

    private lateinit var buyerViewModel: BuyerViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentBuyerBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_buyer, container,false)

        val application = requireNotNull(this.activity).application
        val dao = MarketDatabase.getInstance(application).getMarketDao()
        val repository = MarketRepository(dao)
        val factory = BuyerViewModelFactory(repository, application)

        buyerViewModel = ViewModelProvider(this, factory).get(BuyerViewModel::class.java)

        val adapter = BuyerRVAdapter(listOf(), buyerViewModel)
        binding.recyclerView.layoutManager = LinearLayoutManager(this.activity)
        binding.recyclerView.adapter = adapter

        buyerViewModel.getAllMarketItems().observe(viewLifecycleOwner, Observer {
            adapter.items = it
            adapter.notifyDataSetChanged()
        })

    // Inflate the layout for this fragment
        return binding.root
    }

}