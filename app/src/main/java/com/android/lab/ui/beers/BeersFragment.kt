package com.android.lab.ui.beers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.lab.databinding.FragmentSecondBinding

class BeersFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding
    private lateinit var adapter: BeerAdapter

    private val viewModel: BeersViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSecondBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.beersLiveData.observe(viewLifecycleOwner) {
            adapter.addItems(it)
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        adapter = BeerAdapter()
        binding.recyclerView.adapter = adapter

        viewModel.getBeers()
    }

    companion object {
        private val TAG = BeersFragment::class.java.simpleName
    }
}