package com.example.kubsaunews.activities.saveddata

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kubsaunews.databinding.LayoutItemOfSavedDataBinding
import com.example.kubsaunews.datasourse.db.DataForDb

class SavedDataAdapter(
    private val data: List<DataForDb>,
    val mOnClickDeleteListener: OnClickDeleteListener
) :RecyclerView.Adapter<SavedDataAdapter.SavedDataViewHolder>() {

    interface OnClickDeleteListener {
        fun onDeleteClick(d: DataForDb)
    }

    inner class SavedDataViewHolder(val binding: LayoutItemOfSavedDataBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: DataForDb) {
            binding.txtCard1.text = data.name
            binding.txtCard2.text = data.gender
            binding.txtCard3.text = data.created
            binding.txtCard4.text = data.location
            binding.txtCard5.text = data.species
            binding.txtCard6.text = data.status
            binding.txtCard7.text = data.origin_name
            Glide
                .with(binding.root)
                .load(data.image)
                .into(binding.imgViewCard)
        }

        init {
            binding.btnDelete.setOnClickListener {
                mOnClickDeleteListener.onDeleteClick(data[position])
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SavedDataViewHolder {
        val binding: LayoutItemOfSavedDataBinding =
            LayoutItemOfSavedDataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SavedDataViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SavedDataViewHolder, position: Int) {
        holder.bind(data = data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }


}