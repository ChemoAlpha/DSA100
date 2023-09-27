package com.example.dsa100

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class ThirdActivity : AppCompatActivity() {
    private var choice = "null"
    lateinit var donebtn: Button
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)




        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        val viewPager = findViewById<ViewPager2>(R.id.viewPager)
        choice = intent.getStringExtra("clickedPosition").toString()
        sharedPreferences = getSharedPreferences("DSA100", Context.MODE_PRIVATE)

        donebtn = findViewById(R.id.button)
        if (sharedPreferences.contains("$choice")) {
            donebtn.setBackgroundColor(Color.GREEN)
            donebtn.text="Done"

        } else {
            donebtn.setBackgroundColor(Color.BLUE)
            donebtn.text="Mark As Done"
        }
        donebtn.setOnClickListener {
            if(donebtn.text.equals("Done"))
            {
                Toast.makeText(this,"You marked this problem as done already",Toast.LENGTH_LONG).show()
            }
            else {
                val editor = sharedPreferences.edit()
                editor.putString("$choice", "1")
                editor.apply()
                donebtn.setBackgroundColor(Color.GREEN)
                donebtn.text = "Done"
            }
        }
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
