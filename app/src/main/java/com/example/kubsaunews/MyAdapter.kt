package com.example.kubsaunews

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.example.kubsaunews.data.CharacterData
import com.squareup.picasso.Picasso

class MyAdapter (private val data: CharacterData,
                 val mItemClickListener:ItemClickListener): RecyclerView.Adapter<MyAdapter.NewsViewHolder>()   {

    interface ItemClickListener{
        fun onItemClick(position: Int)
    }

    inner class NewsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val name_tv:TextView = itemView.findViewById(R.id.text_name_id)
        val gender_tv:TextView = itemView.findViewById(R.id.text_gender_id)
        val origin_tv:TextView = itemView.findViewById(R.id.text_origin_id)
        val image_iv:ImageView = itemView.findViewById(R.id.image_id)

        init {
            itemView.setOnClickListener{
                mItemClickListener.onItemClick(adapterPosition)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_item_of_alist, parent, false)
        return NewsViewHolder(itemView)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.name_tv.text = "Name: "+ data.results[position].name
        holder.gender_tv.text = "Gender: "+ data.results[position].gender
        holder.origin_tv.text = "Origin: "+data.results[position].origin.name
        Picasso.get()
            .load(data.results[position].image)
            .resize(1500, 1000)
            .centerInside()
            .into(holder.image_iv)

    }

    override fun getItemCount(): Int {
        return data.results.size
    }
}