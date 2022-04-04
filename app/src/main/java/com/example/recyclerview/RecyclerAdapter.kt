package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private var titles = arrayOf("Dao Duy Lai", "Dang Quoc Khanh", "Le Ba Luong", "Huynh Ngoc Huy")
    private var subtitles = arrayOf("Ham an", "Ham choi", "Ham gai", "Ham lam")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        holder.title.text = titles[position]
        holder.subTitle.text = subtitles[position]
    }

    override fun getItemCount(): Int {
        return titles.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var title: TextView
        var subTitle: TextView

        init {
            title = itemView.findViewById(R.id.txt_title)
            subTitle = itemView.findViewById(R.id.txt_sub_title)
        }
    }
}