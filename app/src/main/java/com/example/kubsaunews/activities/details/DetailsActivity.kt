package com.example.kubsaunews.activities.details

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.kubsaunews.databinding.ActivityDetailsBinding
import java.text.SimpleDateFormat


lateinit var mViewModel: DetailsActivityViewModel

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mViewModel = ViewModelProvider(this)[DetailsActivityViewModel::class.java]

        val id = intent.getIntExtra("id", 0)
        mViewModel.getDetails(id)

        initObservers()
    }

    @SuppressLint("SetTextI18n", "SimpleDateFormat")
    private fun initObservers() {
        mViewModel.apply {
            details.observe(this@DetailsActivity) {
                binding.detailsStatusId.text = "Status: ${it.status}"
                binding.detailsSpeciesId.text = "Species: ${it.species}"
                binding.detailsLocationNameId.text = "Location: ${it.location.name}"
                binding.detailsTitleId.text = it.name

                val parser = SimpleDateFormat("yyyy-MM-dd")
                val formatter = SimpleDateFormat("dd.MM.yyyy")
                val output: String? = parser.parse(it.created)?.let { it1 -> formatter.format(it1) }

                binding.detailsCreatedId.text = "Created: ${output}"

            }
        }
    }

}