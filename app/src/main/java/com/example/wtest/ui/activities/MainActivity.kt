package com.example.wtest.ui.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wtest.databinding.ActivityMainBinding
import com.example.wtest.ui.fragments.LoadingLayerFragment
import com.example.wtest.ui.recycler.AddressListAdapter
import com.example.wtest.ui.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val listAdapter = AddressListAdapter()
        val binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        showLoadingLayer()

        binding.search.setOnQueryTextListener(viewModel)
        binding.addressRecyclerView.apply {
            adapter = listAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

        viewModel.addressList.observe(this, {
            listAdapter.submitList(it)
            if (it.isNotEmpty()) {
                hideLoadingLayer()
            }
        })

        viewModel.filteredList.observe(this, listAdapter::submitList)
    }

    private fun showLoadingLayer() {
        supportFragmentManager.beginTransaction().add(
            android.R.id.content,
            LoadingLayerFragment(),
            LoadingLayerFragment.TAG
        ).commit()
    }

    private fun hideLoadingLayer() {
        val fragment = supportFragmentManager.findFragmentByTag(LoadingLayerFragment.TAG)
        if (fragment != null) {
            supportFragmentManager.beginTransaction().remove(fragment).commit()
        }
    }
}