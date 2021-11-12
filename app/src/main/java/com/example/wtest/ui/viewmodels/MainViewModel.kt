package com.example.wtest.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.wtest.persistence.ContentRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    repository: ContentRepository
) : ViewModel() {

}
