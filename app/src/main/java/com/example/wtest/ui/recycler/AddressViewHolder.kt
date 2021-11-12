package com.example.wtest.ui.recycler

import androidx.recyclerview.widget.RecyclerView
import com.example.wtest.databinding.AddressRecyclerViewItemBinding
import com.example.wtest.model.Address

class AddressViewHolder(
    private val binding: AddressRecyclerViewItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(address: Address?) {
        binding.address = address
    }
}
