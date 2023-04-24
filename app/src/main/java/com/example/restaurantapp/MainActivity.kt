package com.example.restaurantapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.restaurantapp.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    lateinit var bottomNav: BottomNavigationView
    lateinit var binding: ActivityMainBinding
    private val titleFragment = TitleScreen()
    private val menuFragment = MenuFragment()
    private val socialFragment = SocialFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        loadFragment(titleFragment)
        bottomNav = findViewById(R.id.bottom_navigation) as BottomNavigationView
        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.page_1 -> {
                    loadFragment(titleFragment)
                    true
                }
                R.id.page_2 -> {
                    loadFragment(menuFragment)
                    true
                }
                R.id.page_3 -> {
                    loadFragment(socialFragment)
                    true
                }
                else -> {false}
            }

            // Use Data Binding to get reference to the views
            //binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

            /* Will be moved at some point
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
         */
        }


    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.commit()
    }
}