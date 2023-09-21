package com.example.dsa100

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import org.json.JSONObject

class ExtrasFragment : Fragment() {

    lateinit var company:TextView
    lateinit var sde:TextView
    lateinit var link:TextView
    private var data: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_extras, container, false)
      company=view.findViewById(R.id.company)
        sde=view.findViewById(R.id.sdesheet)
        link=view.findViewById(R.id.Links)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (data != null) {

            val resourceId = resources.getIdentifier(data, "raw", requireContext().packageName)
            val jsonData = parseJsonResource(requireContext(), resourceId)
            val extra = jsonData.getJSONObject("extras")
            val companytext = extra.getString("asked")
            val LinkText = extra.getString("relatedlinks")
            val sdeText= extra.getString("sdesheet")
           sde.text=sdeText
            company.text=companytext
            link.text=LinkText

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
