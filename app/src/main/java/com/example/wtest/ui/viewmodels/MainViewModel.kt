package com.example.wtest.ui.viewmodels

import android.widget.SearchView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wtest.persistence.AddressRepository
import com.example.wtest.persistence.entities.Address
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: AddressRepository
) : ViewModel(), SearchView.OnQueryTextListener {

    val addressList = repository.addressList
    val filteredList = MutableLiveData<List<Address>>()

    override fun onQueryTextSubmit(query: String?): Boolean = false

    override fun onQueryTextChange(newText: String?): Boolean {
        filteredList.value = when(newText?.isBlank()) {
            true -> addressList.value
            false -> repository.getAddress(newText)
            null -> null
        }

        return false
    }
}
