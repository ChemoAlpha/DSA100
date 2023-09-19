package com.example.dsa100

import ProblemDataAdapter
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dsa100.model.ProblemData
import org.json.JSONArray
import org.json.JSONObject

class SecondActivity : AppCompatActivity(), ProblemDataAdapter.OnItemClickListener {

    private val problemDataList = mutableListOf<ProblemData>()
    protected lateinit var selected:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val position: Int = intent.getIntExtra("position", -1)
          selected = convertPositionToString(position)
        val jsonRawResourceId = resources.getIdentifier(selected, "raw", packageName)
        val jsonText = resources.openRawResource(jsonRawResourceId).bufferedReader().use { it.readText() }

        parseJsonData(jsonText)
        val adapter = ProblemDataAdapter(this, problemDataList)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter.setOnItemClickListener(this)
    }

    private fun convertPositionToString(position: Int): String {
        val numberWords = arrayOf(
            "zero", "one", "two", "three", "four", "five", "six", "seven",
            "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen",
            "fifteen", "sixteen", "seventeen")

        if (position in 0 until numberWords.size) {
            return numberWords[position]
        } else {
            return "Unknown"
        }
    }

    private fun parseJsonData(jsonText: String) {
        val jsonArray = JSONArray(jsonText)
        for (i in 0 until jsonArray.length()) {
            val jsonObject: JSONObject = jsonArray.getJSONObject(i)

            val problemStatement = jsonObject.getString("problemStatement")
            val difficultyLevel = jsonObject.getString("difficultyLevel")
            val thirdString = jsonObject.getString("thirdString")

            val problemData = ProblemData(problemStatement, difficultyLevel, thirdString)
            problemDataList.add(problemData)
        }
    }
    override fun onItemClick(position: Int) {
        val item = problemDataList[position]
        val intent = Intent(this, ThirdActivity::class.java)
        val nxtselected=convertPositionToString(position)
        intent.putExtra("clickedPosition", selected+nxtselected)
        startActivity(intent)
    }
}
