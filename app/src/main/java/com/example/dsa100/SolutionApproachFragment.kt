package com.example.dsa100

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import org.json.JSONObject

class SolutionApproachFragment : Fragment() {

    lateinit var soultionapproach:TextView
    lateinit var hint:TextView
    private var data: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_solution_approach, container, false)
       soultionapproach=view.findViewById(R.id.soultionapproach)
        hint=view.findViewById(R.id.hint)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (data != null) {
            val resourceId = resources.getIdentifier(data, "raw", requireContext().packageName)
            val jsonData = parseJsonResource(requireContext(), resourceId)
          val soultionA = jsonData.getJSONObject("solution_approach")
          val soultiontext = soultionA.getString("solution")
            val hinttext = soultionA.getString("hint")
           soultionapproach.text=soultiontext
            hint.text=hinttext
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
