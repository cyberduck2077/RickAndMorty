package com.example.kubsaunews.activities.start

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kubsaunews.activities.details.DetailsActivity
import com.example.kubsaunews.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MyAdapter.ItemClickListener {

    lateinit var binding: ActivityMainBinding
    private lateinit var mViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initRecyclerView()
        mViewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]

        mViewModel.getCharacters()
        initObservers()
        initButtonsClickListeners()
        binding.prevPage.isEnabled=false
    }

    private fun initButtonsClickListeners() {

        binding.nextPage.setOnClickListener{
            binding.prevPage.isEnabled = true
            mViewModel.currentPage.apply {
                value = value?.plus(1)
            }
            mViewModel.getCharacters()
        }

        binding.prevPage.setOnClickListener {
            mViewModel.currentPage.apply {
                value = value?.minus(1)
                if(value==1)
                    binding.prevPage.isEnabled=false
            }
            mViewModel.getCharacters()
        }
    }

    private fun initObservers() {
        mViewModel.apply {
            characters.observe(this@MainActivity) {
                binding.recyclerId.adapter = MyAdapter(it, this@MainActivity)
            }
        }
    }

    private fun initRecyclerView() {
        binding.recyclerId.layoutManager = LinearLayoutManager(this)
        binding.recyclerId.setHasFixedSize(true)
    }

    override fun onItemClick(position: Int) {
        val intent = Intent(this@MainActivity, DetailsActivity::class.java)
        intent.putExtra("id", position)
        startActivity(intent)
    }
}