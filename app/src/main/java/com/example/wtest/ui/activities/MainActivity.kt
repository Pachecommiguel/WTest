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

        binding.addressRecyclerView.apply {
            adapter = listAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

        supportFragmentManager.beginTransaction().add(android.R.id.content, LoadingLayerFragment(), LoadingLayerFragment.TAG).commit()

        viewModel.addressList.observe(this, {
            listAdapter.submitList(it)
            val fragment = supportFragmentManager.findFragmentByTag(LoadingLayerFragment.TAG)
            if (fragment != null && it.isNotEmpty()) {
                supportFragmentManager.beginTransaction().remove(fragment).commit()
            }
        })
    }
}