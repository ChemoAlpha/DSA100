package com.example.dsa100

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.dsa100.model.MainModel

class MainAdapter(private val context: Context, private val dataList: List<MainModel>) :
    RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_main_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.findViewById(R.id.textView)
        private val noProblemsTextView: TextView = itemView.findViewById(R.id.textView2)
        private val iconImageView: ImageView = itemView.findViewById(R.id.imageView)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {

                    val intent = Intent(context, SecondActivity::class.java)
                    intent.putExtra("position", position)
                    context.startActivity(intent)
                }
            }

        }
        fun bind(item: MainModel) {
            titleTextView.text = item.Topic_Title
            noProblemsTextView.text = item.No_Problems
            iconImageView.setImageResource(item.Icon_id)
        }
    }
}