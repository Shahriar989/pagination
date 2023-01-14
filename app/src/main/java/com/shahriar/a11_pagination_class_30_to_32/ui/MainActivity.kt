package com.shahriar.a11_pagination_class_30_to_32.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.shahriar.a11_pagination_class_30_to_32.R
import com.shahriar.a11_pagination_class_30_to_32.databinding.ActivityMainBinding
import com.shahriar.a11_pagination_class_30_to_32.ui.adapters.QuotesAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    lateinit var viewModel: QuoteViewModel

    lateinit var adapter: QuotesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = QuotesAdapter()
        binding.quotesRecyclerView.adapter = adapter
        binding.quotesRecyclerView.setHasFixedSize(true)

        viewModel = ViewModelProvider(this)[QuoteViewModel::class.java]
        viewModel.quoteList.observe(this){

        adapter.submitData(lifecycle, it)
        }
    }
}