package com.example.dsa100

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dsa100.model.MainModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
          val iconID = intArrayOf(R.drawable.array,R.drawable.stack,R.drawable.ptrs,R.drawable.bit,R.drawable.hashing,R.drawable.gcdmod,R.drawable.sorting,R.drawable.searching,R.drawable.string,R.drawable.linklist,R.drawable.tree,R.drawable.queue,R.drawable.heap,R.drawable.recursion,R.drawable.dyanamic,R.drawable.graph)
          val Title  = arrayOf("Arrays","Stack","2-Ptrs","Bit Manuplation","Hashing","GCD & MOD ","Sorting","Searching Algo","String & Algo","Link List","Tree & Trie's","Queue's","Heap","Recursion","DP & BackTracking","Graph")
          val no_problem= arrayOf("11 Problems","6 Problems","4 Problems","4 Problems","6 Problems","5 Problmes","4 Problems","5 Problems","5 Problems","6 Problems","9 Problems","6 Problmes","3 Problems","7 Problems","11 Problems","9 Problmes")
        val mainModelArray = ArrayList<MainModel>()
        for (i in iconID.indices) {
            val mainModel = MainModel( Title[i], no_problem[i],iconID[i])
            mainModelArray.add(mainModel)
        }

      val rc:RecyclerView=findViewById(R.id.Main_List)
        val adapter = MainAdapter(this, mainModelArray)
        val layoutManager = LinearLayoutManager(this)
        rc.layoutManager = layoutManager
        rc.adapter = adapter


    }
}