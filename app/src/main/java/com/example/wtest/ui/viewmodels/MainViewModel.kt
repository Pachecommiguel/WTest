package com.example.wtest.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.wtest.model.Address
import com.example.wtest.persistence.AddressRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: AddressRepository
) : ViewModel() {

    lateinit var addressList: LiveData<List<Address>>
}
