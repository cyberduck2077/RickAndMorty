package com.example.kubsaunews.presentation.start

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kubsaunews.databinding.ActivityMainBinding
import com.example.kubsaunews.presentation.details.DetailsActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(), MyAdapter.ItemClickListener {

    lateinit var binding: ActivityMainBinding

    private val mViewModel by viewModel<MainActivityViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initRecyclerView()

        mViewModel.getCharacterList()
        initObservers()
        initButtonsClickListeners()
        binding.prevPage.isEnabled = false
    }

    private fun initButtonsClickListeners() {

        binding.nextPage.setOnClickListener {
            binding.prevPage.isEnabled = true
            mViewModel.currentPage.apply {
                value = value?.plus(1)
            }
            mViewModel.getCharacterList()
        }

        binding.prevPage.setOnClickListener {
            mViewModel.currentPage.apply {
                value = value?.minus(1)
                if (value == 1)
                    binding.prevPage.isEnabled = false
            }
            mViewModel.getCharacterList()
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