package com.example.dsa100

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.viewpager2.widget.ViewPager2 // Updated import


class WelcomeActivity : AppCompatActivity() {

    private val fragments = listOf(
        FirstFragment(),
        SecondFragment(),
        ThirdFragment()
    )
    private lateinit var viewPager: ViewPager2 // Updated declaration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        viewPager = findViewById(R.id.viewPager3)
        val pagerAdapter = ViewPagerAdapter(this, fragments)
        viewPager.adapter = pagerAdapter

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                updateDots(position)
            }
        })
    }

    private fun updateDots(position: Int) {
        val dot1 = findViewById<ImageView>(R.id.dot1)
        val dot2 = findViewById<ImageView>(R.id.dot2)
        val dot3 = findViewById<ImageView>(R.id.dot3)

        dot1.setImageResource(if (position == 0) R.drawable.dot_selected else R.drawable.dot_unselected)
        dot2.setImageResource(if (position == 1) R.drawable.dot_selected else R.drawable.dot_unselected)
        dot3.setImageResource(if (position == 2) R.drawable.dot_selected else R.drawable.dot_unselected)
    }
}
