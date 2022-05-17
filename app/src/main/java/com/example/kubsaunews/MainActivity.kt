package com.example.kubsaunews

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kubsaunews.data.CharacterData
import com.example.kubsaunews.modelview.CharacterDataModelView
import com.example.kubsaunews.retrofit.InterfaceAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), MyAdapter.ItemClickListener {

    lateinit var recyclerView: RecyclerView

    private val mViewModel: CharacterDataModelView = CharacterDataModelView()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        initView()
        initObservers()
        mViewModel.getCharacters()
    }

    private fun initObservers() {
        mViewModel.apply {
            characters.observe(this@MainActivity){
                recyclerView.adapter = MyAdapter(it, this@MainActivity)
            }
        }
    }

    private fun initView() {
        recyclerView = findViewById(R.id.recycler_id)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
    }

    override fun onItemClick(position: Int) {
        val intent = Intent(this@MainActivity, DetailsActivity::class.java)
                intent.putExtra("id",position)
                startActivity(intent)
    }

//    private fun initList() {
//
//        val interfaceAPI = InterfaceAPI.create().getUser()
//
//        interfaceAPI.enqueue( object : Callback<CharacterData>, MyAdapter.ItemClickListener {
//
//            @SuppressLint("NotifyDataSetChanged")
//            override fun onResponse(call: Call<CharacterData>?, response: Response<CharacterData>?) {
//
////                Log.d("TTT","OnResponseSuccess first name = ${response?.body()?.get(2)?.ACTIVE_FROM}")
//
//                if(response?.body() != null) {
//                    recyclerView.adapter = MyAdapter(response.body() as CharacterData, this)
//                    (recyclerView.adapter as MyAdapter).notifyDataSetChanged()
//                }
//            }
//
//            override fun onFailure(call: Call<CharacterData>?, t: Throwable?) {
//
//               Log.d("TTT","onFailure : ${t?.message}")
//            }
//
//            override fun onItemClick(id: Int) {
//                val intent = Intent(this@MainActivity, DetailsActivity::class.java)
//                intent.putExtra("id",id)
//                startActivity(intent)
//            }
//        })
//    }
}