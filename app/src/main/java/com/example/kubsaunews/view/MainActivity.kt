package com.example.kubsaunews.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kubsaunews.R
import com.example.kubsaunews.modelview.CharacterDataModelView

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
}