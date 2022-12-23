package com.example.kubsaunews.app.details

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.kubsaunews.app.saveddata.SavedDataActivity
import com.example.kubsaunews.databinding.ActivityDetailsBinding
import com.example.kubsaunews.domain.models.CharacterModel
import java.text.SimpleDateFormat


lateinit var mViewModel: DetailsActivityViewModel

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding
    private lateinit var character: CharacterModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mViewModel = ViewModelProvider(this)[DetailsActivityViewModel::class.java]

        val id = intent.getIntExtra("id", 0)
        mViewModel.getDetails(id)

        initObservers()

        initEventListeners()


    }

    private fun initEventListeners() {
        binding.btnShowcharacters.setOnClickListener {
            val intent = Intent(this@DetailsActivity, SavedDataActivity::class.java)
            startActivity(intent)
        }

        binding.checkbox.setOnClickListener {
            if (binding.checkbox.isChecked) {
                mViewModel.apply {
                    saveData(character)
                }
            }

        }
    }

    @SuppressLint("SetTextI18n", "SimpleDateFormat")
    private fun initObservers() {
        mViewModel.apply {
            details.observe(this@DetailsActivity) {
                binding.detailsStatusId.text = "Status: ${it.status}"
                binding.detailsSpeciesId.text = "Species: ${it.species}"
                binding.detailsLocationNameId.text = "Location: ${it.location_name}"
                binding.detailsTitleId.text = it.name

                val parser = SimpleDateFormat("yyyy-MM-dd")
                val formatter = SimpleDateFormat("dd.MM.yyyy")
                val output: String? = parser.parse(it.created)?.let { it1 -> formatter.format(it1) }

                binding.detailsCreatedId.text = "Created: ${output}"

                it.apply {
                    character = CharacterModel(
                        created = created,
                        episode = episode,
                        gender = gender,
                        id = id,
                        image = image,
                        location_name = location_name,
                        name = name,
                        origin_name = origin_name,
                        origin_url = origin_url,
                        species = species,
                        status = status,
                        type = type,
                        url = url
                    )
                }

            }
        }
    }

}