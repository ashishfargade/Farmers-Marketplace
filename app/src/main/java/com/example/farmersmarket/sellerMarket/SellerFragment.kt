package com.example.farmersmarket.sellerMarket

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
import com.example.farmersmarket.databinding.FragmentSellerBinding
import com.example.farmersmarket.marketDB.MarketDatabase
import com.example.farmersmarket.marketDB.MarketEntity
import com.example.farmersmarket.marketDB.MarketRepository
import kotlinx.android.synthetic.main.fragment_seller.*


class SellerFragment : Fragment() {

    private lateinit var sellerViewModel: SellerViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentSellerBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_seller, container, false
        )

        val application = requireNotNull(this.activity).application
        val dao = MarketDatabase.getInstance(application).getMarketDao()
        val repository = MarketRepository(dao)
        val factory = SellerViewModelFactory(repository, application)

        sellerViewModel = ViewModelProvider(this, factory).get(SellerViewModel::class.java)

        val adapter = SellerRVAdapter(listOf(), sellerViewModel)
        binding.recyclerView.layoutManager = LinearLayoutManager(this.activity)
        binding.recyclerView.adapter = adapter

        sellerViewModel.getAllMarketItems().observe(viewLifecycleOwner, Observer {
            adapter.items = it
            adapter.notifyDataSetChanged()
        })


        binding.addButton.setOnClickListener {
            this.context?.let { it1 ->
                AddDialog(
                    it1,
                    object : AddDialogListener{
                        override fun onAddButtonClicked(item: MarketEntity) {
                            sellerViewModel.insert(item)
                        }
                    }).show()
            }
            }


        // Inflate the layout for this fragment
        return binding.root
    }

}