package com.example.kubsaunews.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatTextView
import com.example.kubsaunews.R
import com.example.kubsaunews.modelview.DetailsModelView
import java.text.SimpleDateFormat

lateinit var txt_status:AppCompatTextView
lateinit var txt_species:AppCompatTextView
lateinit var txt_location_name:AppCompatTextView
lateinit var txt_title:AppCompatTextView
lateinit var txt_created:AppCompatTextView

private val mViewModel:DetailsModelView = DetailsModelView()

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val id = intent.getIntExtra("id", 0)

        Toast.makeText(this,"id = ${id.toString()}", Toast.LENGTH_SHORT).show()

        initViews()
        initObservers()
        mViewModel.getDetails(id)
    }

    @SuppressLint("SetTextI18n", "SimpleDateFormat")
    private fun initObservers() {
        mViewModel.apply {
            details.observe(this@DetailsActivity){
                txt_status.text = "Status: ${it.status}"
                txt_species.text = "Species: ${it.species}"
                txt_location_name.text = "Location: ${it.location.name}"
                txt_title.text = it.name

                val parser = SimpleDateFormat("yyyy-MM-dd")
                val formatter = SimpleDateFormat("dd.MM.yyyy")
                val output: String? = parser.parse(it.created)?.let { it1 -> formatter.format(it1) }

                txt_created.text = "Created: ${output}"

            }
        }
    }

    private fun initViews() {
        txt_status = findViewById(R.id.details_status_id)
        txt_species = findViewById(R.id.details_species_id)
        txt_location_name = findViewById(R.id.details_location_name_id)
        txt_title = findViewById(R.id.details_title_id)
        txt_created = findViewById(R.id.details_created_id)
    }
}