package com.android.lab

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.lab.R
import com.android.lab.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding

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

        val items = listOf(
            ItemData(R.drawable.item_1, R.string.item_1),
            ItemData(R.drawable.item_2, R.string.item_2),
            ItemData(R.drawable.item_3, R.string.item_3),
            ItemData(R.drawable.item_1, R.string.item_1),
            ItemData(R.drawable.item_2, R.string.item_2),
            ItemData(R.drawable.item_3, R.string.item_3),
            ItemData(R.drawable.item_1, R.string.item_1),
            ItemData(R.drawable.item_2, R.string.item_2),
            ItemData(R.drawable.item_3, R.string.item_3),
            ItemData(R.drawable.item_1, R.string.item_1),
            ItemData(R.drawable.item_2, R.string.item_2),
            ItemData(R.drawable.item_3, R.string.item_3),
            ItemData(R.drawable.item_1, R.string.item_1),
            ItemData(R.drawable.item_2, R.string.item_2),
            ItemData(R.drawable.item_3, R.string.item_3),
            ItemData(R.drawable.item_1, R.string.item_1),
            ItemData(R.drawable.item_2, R.string.item_2),
            ItemData(R.drawable.item_3, R.string.item_3),
            ItemData(R.drawable.item_1, R.string.item_1),
            ItemData(R.drawable.item_2, R.string.item_2),
            ItemData(R.drawable.item_3, R.string.item_3),
            ItemData(R.drawable.item_1, R.string.item_1),
            ItemData(R.drawable.item_2, R.string.item_2),
            ItemData(R.drawable.item_3, R.string.item_3),
            ItemData(R.drawable.item_1, R.string.item_1),
            ItemData(R.drawable.item_2, R.string.item_2),
            ItemData(R.drawable.item_3, R.string.item_3)
        )

        Log.d(TAG, "Item size: " + items.size)

        binding.recyclerView.adapter = ListAdapter(items)
    }

    companion object {
        private val TAG = SecondFragment::class.java.simpleName
    }
}