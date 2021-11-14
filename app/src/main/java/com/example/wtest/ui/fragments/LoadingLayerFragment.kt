package com.example.wtest.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.wtest.R

class LoadingLayerFragment : Fragment() {

    companion object {
        const val TAG = "LoadingLayerFragment"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.loading_layer_fragment, container, false)
    }
}