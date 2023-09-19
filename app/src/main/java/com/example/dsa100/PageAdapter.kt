package com.example.dsa100

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ThirdPagerAdapter(fragmentActivity: FragmentActivity, private val data: String) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return 4 // Four tabs
    }

    override fun createFragment(position: Int): Fragment {
        // Pass the 'data' to each fragment
        return when (position) {
            0 -> {
                val problemFragment = ProblemFragment()
                problemFragment.setData(data)
                problemFragment
            }
            1 ->
            {
                val soul= SolutionApproachFragment()
                soul.setData(data)
                soul
            }
            2 -> {
                val soul1=SolutionFragment()
                soul1.setData(data)
                soul1
            }
            3 -> {
                val ext=ExtrasFragment()
                ext.setData(data)
                ext
            }
            else -> throw IllegalArgumentException("Invalid tab position")
        }
    }
}
