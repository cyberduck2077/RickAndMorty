package com.example.kubsaunews.activities.saveddata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.HorizontalScrollView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kubsaunews.databinding.ActivitySavedDataBinding

class SavedDataActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySavedDataBinding
    lateinit var savedDataViewModel: SavedDataViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySavedDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        savedDataViewModel = ViewModelProvider(this)[SavedDataViewModel::class.java]

        initRecyclerView()

        savedDataViewModel.getAllDataFromDb()
        initObservers()

    }

    private fun initRecyclerView() {
        binding.rvSaved.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        binding.rvSaved.setHasFixedSize(true)
    }

    private fun initObservers() {

        savedDataViewModel.apply {

            liveDataListSavedData.observe(this@SavedDataActivity) {
                binding.rvSaved.adapter = SavedDataAdapter(it)
            }

        }

    }
}