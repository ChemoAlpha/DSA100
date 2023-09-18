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
          val iconID = intArrayOf(R.drawable.ic_icon,R.drawable.ic_icon,R.drawable.ic_icon,R.drawable.ic_icon,R.drawable.ic_icon,R.drawable.ic_icon,R.drawable.ic_icon,R.drawable.ic_icon,R.drawable.ic_icon,R.drawable.ic_icon,R.drawable.ic_icon,R.drawable.ic_icon)
          val Title  = arrayOf("Array","Hash","List","Map","Heap","Tree","Array","Hash","List","Map","Heap","Tree")
          val no_problem= arrayOf("10 Problems","7 Problems","4 Problems","5 Problems","9 Problems","10 Problmes","10 Problems","7 Problems","4 Problems","5 Problems","9 Problems","10 Problmes")
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