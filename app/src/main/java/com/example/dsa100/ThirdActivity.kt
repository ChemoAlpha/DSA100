package com.example.dsa100

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class ThirdActivity : AppCompatActivity() {
    private var choice = "null"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        val viewPager = findViewById<ViewPager2>(R.id.viewPager)
        choice = intent.getStringExtra("clickedPosition").toString()

        val adapter = ThirdPagerAdapter(this, choice) // Pass the choice to the adapter
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Problem Statement" }
                1 -> tab.text = "Solution Approach"
                2 -> tab.text = "Solution"
                3 -> tab.text = "Extra's"
            }
        }.attach()
    }

    fun getStr(): String {
        return choice
    }
}
