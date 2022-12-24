package com.example.kubsaunews.presentation.start

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kubsaunews.databinding.ActivityItemOfListBinding
import com.example.kubsaunews.domain.models.CharacterModel

class MyAdapter(
    private val list: List<CharacterModel>,
    val mItemClickListener: ItemClickListener,
) : RecyclerView.Adapter<MyAdapter.NewsViewHolder>() {

    interface ItemClickListener {
        fun onItemClick(position: Int)
    }


    inner class NewsViewHolder(val binding: ActivityItemOfListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(_list: List<CharacterModel>, p: Int) {
            binding.textNameId.text = "Name: " + list[p].name
            binding.textGenderId.text = "Gender: " + list[p].gender
            binding.textOriginId.text = "Origin: " + list[p].origin_name
            binding.progressBar.visibility = View.GONE
            Glide
                .with(binding.root)
                .load(list[position].image)
                .into(binding.imageId)
        }


        init {
            itemView.setOnClickListener {
                mItemClickListener.onItemClick(list[position].id_in_server)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val binding =
            ActivityItemOfListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(list, position)

    }

    override fun getItemCount(): Int {
        return list.size
    }
}