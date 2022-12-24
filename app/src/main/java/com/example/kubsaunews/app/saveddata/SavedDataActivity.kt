package com.example.kubsaunews.app.saveddata

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kubsaunews.databinding.ActivitySavedDataBinding
import com.example.kubsaunews.domain.models.CharacterModel

class SavedDataActivity : AppCompatActivity(), SavedDataAdapter.OnClickDeleteListener {

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
        binding.rvSaved.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.rvSaved.setHasFixedSize(true)
    }

    private fun initObservers() {

        savedDataViewModel.apply {

            liveDataListSavedData.observe(this@SavedDataActivity) {
                binding.rvSaved.adapter = SavedDataAdapter(it, this@SavedDataActivity)
            }

        }

    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onDeleteClick(d: CharacterModel) {
        savedDataViewModel.deleteData(d)
        savedDataViewModel.getAllDataFromDb()
        binding.rvSaved.adapter?.notifyDataSetChanged()
        if (savedDataViewModel.isSuccessDelete.value == true)
            Toast.makeText(this, "Character deleted successful!", Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(this, "Character deleted unsuccessful\nSee Logs", Toast.LENGTH_SHORT).show()
    }
}