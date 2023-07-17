package com.android.lab.ui.beers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.lab.databinding.FragmentBeersBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class BeersFragment : Fragment() {

    private lateinit var binding: FragmentBeersBinding
    private lateinit var adapter: BeerAdapter

    private val viewModel: BeersViewModel by viewModel()
    //private lateinit var viewModel: BeersViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBeersBinding.inflate(inflater)

        //val viewModelFactory = BeersViewModelFactory((activity?.application as BeersApplication))
        //viewModel = viewModelFactory.create(BeersViewModel::class.java)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Register to obtain beers list
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