package com.example.dsa100

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import org.json.JSONObject

class SolutionFragment : Fragment() {

    lateinit var java:TextView
    lateinit var python:TextView
    private var data: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_solution, container, false)
        java=view.findViewById(R.id.java)
        python=view.findViewById(R.id.python)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (data != null) {
            val jsonData = parseJsonResource(requireContext(), R.raw.data)
            val soultion = jsonData.getJSONObject("solution")
            val javatext = soultion.getString("java")
            val pythontext = soultion.getString("python")
            java.text=javatext
            python.text=pythontext

        }
    }

    fun setData(data: String) {
        this.data = data
    }

    fun parseJsonResource(context: Context, resourceId: Int): JSONObject {
        val inputStream = context.resources.openRawResource(resourceId)
        val jsonContent = inputStream.bufferedReader().use { it.readText() }
        return JSONObject(jsonContent)
    }
}
