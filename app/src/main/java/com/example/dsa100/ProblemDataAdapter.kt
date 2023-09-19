import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.recyclerview.widget.RecyclerView
import com.example.dsa100.R
import com.example.dsa100.model.ProblemData

class ProblemDataAdapter(private val context: Context, private val problemDataList: List<ProblemData>) :
    RecyclerView.Adapter<ProblemDataAdapter.ViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    private var itemClickListener: OnItemClickListener? = null

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewProblemStatement: TextView = itemView.findViewById(R.id.textViewProblemStatement)
        val textViewDifficultyLevel: TextView = itemView.findViewById(R.id.textViewDifficultyLevel)
        val textViewThirdString: TextView = itemView.findViewById(R.id.textViewThirdString)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    itemClickListener?.onItemClick(position)
                }
            }
        }
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        itemClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_problem, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val problemData = problemDataList[position]

        holder.textViewProblemStatement.text = problemData.problemStatement
        holder.textViewDifficultyLevel.text = problemData.difficultyLevel
        if(problemData.difficultyLevel.equals("Easy"))
        {
            holder.textViewDifficultyLevel.setTextColor(Color.CYAN)
        }
        else if(problemData.difficultyLevel.equals("Medium"))
        {
            holder.textViewDifficultyLevel.setTextColor(Color.YELLOW)
        }
        else
        {
            holder.textViewDifficultyLevel.setTextColor(Color.RED)
        }
        holder.textViewThirdString.text = problemData.thirdString
    }

    override fun getItemCount(): Int {
        return problemDataList.size
    }
}
