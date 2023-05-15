package com.android.lab

import android.content.Context
import android.os.Bundle
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.android.lab.R
import com.android.lab.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val context: Context = this


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*binding.firstFragmentButton.setOnClickListener {
            Log.d(TAG, "Navigate to first fragment")
            navigateToFragment(R.id.firstFragment)
        }

        binding.secondFragmentButton.setOnClickListener {
            Log.d(TAG, "Navigate to second fragment")
            navigateToFragment(R.id.secondFragment)
        }*/
    }

    private fun navigateToFragment(@IdRes navigationResId: Int) {
        val navController = findNavController(R.id.nav_host_fragment)
        navController.navigate(navigationResId)
    }

    companion object {
        val TAG: String = MainActivity::class.java.simpleName
    }
}