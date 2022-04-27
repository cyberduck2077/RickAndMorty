package com.example.kubsaunews

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kubsaunews.data.CharacterData
import com.example.kubsaunews.retrofit.InterfaceAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_id)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        initList()
    }

    private fun initList() {

        val interfaceAPI = InterfaceAPI.create().getUser()

        interfaceAPI.enqueue( object : Callback<CharacterData>, MyAdapter.ItemClickListener {

            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(call: Call<CharacterData>?, response: Response<CharacterData>?) {

//                Log.d("TTT","OnResponseSuccess first name = ${response?.body()?.get(2)?.ACTIVE_FROM}")

                if(response?.body() != null) {
                    recyclerView.adapter = MyAdapter(response.body() as CharacterData, this)
                    (recyclerView.adapter as MyAdapter).notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<CharacterData>?, t: Throwable?) {

               Log.d("TTT","onFailure : ${t?.message}")
            }

            override fun onItemClick(position: Int) {
                Toast.makeText(this@MainActivity, "position = $position",Toast.LENGTH_SHORT).show()
            }
        })
    }
}