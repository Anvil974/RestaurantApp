package com.example.restaurantapp

import android.R.attr.button
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.restaurantapp.databinding.ActivityMainBinding
import org.w3c.dom.Text


// Contains all the views
@SuppressLint("StaticFieldLeak")
private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Use Data Binding to get reference to the views
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.displayAddressButton.setOnClickListener {
                // Code here executes on main thread after user presses button
            if(binding.Address.visibility == View.GONE) {
                binding.Address.visibility = View.VISIBLE
            } else {
                binding.Address.visibility = View.GONE
            }

        }

        binding.displayHoursButton.setOnClickListener {
            if(binding.Hours.visibility == View.GONE) {
                binding.Hours.visibility = View.VISIBLE
            } else {
                binding.Hours.visibility = View.GONE
            }
        }
    }



}