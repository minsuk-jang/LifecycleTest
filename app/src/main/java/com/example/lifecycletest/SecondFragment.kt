package com.example.lifecycletest

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import com.example.lifecycletest.databinding.FragmentSecondBinding

class SecondFragment : BaseFragment<FragmentSecondBinding>(R.layout.fragment_second) {
    companion object {
        fun getInstance(): SecondFragment = SecondFragment().apply {
            arguments = bundleOf()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}