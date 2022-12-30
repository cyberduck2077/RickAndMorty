package com.example.kubsaunews.presentation.saveddata

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isEmpty
import androidx.core.view.size
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kubsaunews.databinding.ActivitySavedDataBinding
import com.example.kubsaunews.domain.models.CharacterModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SavedDataActivity : AppCompatActivity(), SavedDataAdapter.OnClickDeleteListener {

    private lateinit var binding: ActivitySavedDataBinding

    private val savedDataViewModel by viewModel<SavedDataViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySavedDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()

        savedDataViewModel.getAllDataFromDb()
        initObservers()

    }

    private fun initRecyclerView() {
        binding.rvSaved.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.rvSaved.setHasFixedSize(true)
    }

    @SuppressLint("ShowToast")
    private fun initObservers() {

        savedDataViewModel.apply {

            liveDataListSavedData.observe(this@SavedDataActivity) {
                binding.rvSaved.adapter = SavedDataAdapter(it, this@SavedDataActivity)
                if(it.isEmpty()) {
                    this@SavedDataActivity.finish()
                    Toast.makeText(applicationContext, "Data Base is Empty", Toast.LENGTH_SHORT).show()
                }
            }

        }

    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onDeleteClick(d: CharacterModel) {
        savedDataViewModel.deleteData(d)
        savedDataViewModel.getAllDataFromDb()
        binding.rvSaved.adapter?.notifyDataSetChanged()
    }
}