package com.example.wtest.ui.recycler

import androidx.recyclerview.widget.DiffUtil
import com.example.wtest.persistence.entities.Address

class AddressDiffCallback : DiffUtil.ItemCallback<Address>() {
    override fun areItemsTheSame(oldItem: Address, newItem: Address): Boolean {
        return oldItem.key == newItem.key
    }

    override fun areContentsTheSame(oldItem: Address, newItem: Address): Boolean {
        return oldItem.location == newItem.location &&
                oldItem.threeDigits == newItem.threeDigits &&
                oldItem.fourDigits == newItem.fourDigits
    }
}
