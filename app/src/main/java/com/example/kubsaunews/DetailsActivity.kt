package com.example.kubsaunews

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.widget.AppCompatTextView
import com.example.kubsaunews.data.Result
import com.example.kubsaunews.retrofit.InterfaceAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

lateinit var txt_name:AppCompatTextView
lateinit var txt_status:AppCompatTextView
lateinit var txt_species:AppCompatTextView
lateinit var txt_location_name:AppCompatTextView

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val id = intent.getIntExtra("id", 0)

        Toast.makeText(this,"id = ${id.toString()}", Toast.LENGTH_SHORT).show()

        initDetails(id)

        txt_name = findViewById(R.id.details_name_id)
        txt_status = findViewById(R.id.details_status_id)
        txt_species = findViewById(R.id.details_species_id)
        txt_location_name = findViewById(R.id.details_location_name_id)

    }

    private fun initDetails(id:Int) {
        val interfaceAPI = InterfaceAPI.create().getDetails(id)

        interfaceAPI.enqueue(object : Callback<Result>{
            @SuppressLint("SetTextI18n")
            override fun onResponse(call: Call<Result>, response: Response<Result>) {
                txt_name.text = "Name: ${response.body()?.name}"
                txt_status.text = "Status: ${response.body()?.status}"
                txt_species.text = "Species: ${response.body()?.species}"
                txt_location_name.text = "Location: ${response.body()?.location?.name}"
            }

            override fun onFailure(call: Call<Result>, t: Throwable) {
                Log.d("TTT","onFailure : ${t.message}")
            }

        })


    }
}