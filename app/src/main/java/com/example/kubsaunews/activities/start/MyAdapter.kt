package com.example.kubsaunews.activities.start

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kubsaunews.databinding.ActivityItemOfListBinding
import com.example.kubsaunews.models.CharacterData

class MyAdapter(
    private val data: CharacterData,
    val mItemClickListener: ItemClickListener,
) : RecyclerView.Adapter<MyAdapter.NewsViewHolder>() {

    interface ItemClickListener {
        fun onItemClick(position: Int)
    }


    inner class NewsViewHolder(val binding: ActivityItemOfListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(_data: CharacterData, p: Int) {
            binding.textNameId.text = "Name: " + data.results[p].name
            binding.textGenderId.text = "Gender: " + data.results[p].gender
            binding.textOriginId.text = "Origin: " + data.results[p].origin.name
            binding.progressBar.visibility = View.GONE
            Glide
                .with(binding.root)
                .load(data.results[position].image)
                .into(binding.imageId)
        }


        init {
            itemView.setOnClickListener {
                mItemClickListener.onItemClick(data.results.get(position).id)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val binding =
            ActivityItemOfListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(data, position)

    }

    override fun getItemCount(): Int {
        return data.results.size
    }
}