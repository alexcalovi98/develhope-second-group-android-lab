package com.android.lab.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.lab.BeerAdapter
import com.android.lab.databinding.FragmentSecondBinding
import com.android.lab.repository.PunkAPI
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding
    private lateinit var adapter: BeerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSecondBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        adapter = BeerAdapter()
        binding.recyclerView.adapter = adapter

        //Retrofit test

        //Retrofit client creation
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.punkapi.com/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        //API creation
        val punkAPI = retrofit.create(PunkAPI::class.java)

        lifecycleScope.launch {
            val beers = punkAPI.getBeers(1)
            //beers.forEach {
            //Log.d(TAG, "$it")
            //}
            val items = beers.map { BeerItem(it.name, it.imageUrl) }
            Log.d(TAG,"$items")
            adapter.addItems(items)
        }
    }

    companion object {
        private val TAG = SecondFragment::class.java.simpleName
    }
}