package com.example.dsa100

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dsa100.model.MainModel

class MainActivity : AppCompatActivity()
{
    lateinit var progresstext:TextView
    lateinit var nametext:TextView
    lateinit var sharedPreferences:SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sharedPreferences=getSharedPreferences("DSA100", Context.MODE_PRIVATE)
        val allKeys = sharedPreferences.all.keys
        val numberOfVariables = allKeys.size
        progresstext=findViewById(R.id.progress)
        progresstext.text=numberOfVariables.toString()
        val name = sharedPreferences.getString("name", null)
        if (name != null) {
            nametext = findViewById(R.id.name)
            nametext.text = name
        }
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

    override fun onResume() {
        super.onResume()
        val allKeys = sharedPreferences.all.keys
        val numberOfVariables = allKeys.size
        progresstext.text=numberOfVariables.toString()
    }

}