package com.example.dsa100

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import org.json.JSONObject

class ProblemFragment : Fragment() {
    lateinit var problemtitle:TextView
    lateinit var problemdesc:TextView
    lateinit var problemconst:TextView
    lateinit var inputf:TextView
    lateinit var outputf:TextView
    lateinit var example1:TextView

    private var data: String? = null // Variable to store data passed from ThirdActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_problem, container, false)

        problemtitle=view.findViewById(R.id.problemtitle)
        problemdesc=view.findViewById(R.id.problemdescription)
        problemconst=view.findViewById(R.id.problemdeconst)
        inputf=view.findViewById(R.id.inputFormat)
        outputf=view.findViewById(R.id.outputformat)
        example1=view.findViewById(R.id.example1)

        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        super.onViewCreated(view, savedInstanceState)


        if (data != null)
        {
            val resourceId = resources.getIdentifier(data, "raw", requireContext().packageName)
            val jsonData = parseJsonResource(requireContext(), resourceId)
            val problemStatement = jsonData.getJSONObject("problem_statement")
            val title = problemStatement.getString("title")
            val problemDescription = problemStatement.getString("problemdescription")
            val problemConstraint = problemStatement.getString("problemconstraint")
            val inputFormat = problemStatement.getString("inputformat")
            val outputFormat = problemStatement.getString("outputformat")
            val example = problemStatement.getString("example")

            problemtitle.text=title
            problemdesc.text = problemDescription
            problemconst.text = problemConstraint
            inputf.text = inputFormat
            outputf.text = outputFormat
            example1.text = example





        }
    }

    // Function to set 'data' from ThirdActivity
    fun setData(data: String) {
        this.data = data
    }
    fun parseJsonResource(context: Context, resourceId: Int): JSONObject {
        val inputStream = context.resources.openRawResource(resourceId)
        val jsonContent = inputStream.bufferedReader().use { it.readText() }
        return JSONObject(jsonContent)
    }
}
