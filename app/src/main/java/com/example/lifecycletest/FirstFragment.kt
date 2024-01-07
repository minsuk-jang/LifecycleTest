package com.example.lifecycletest

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.lifecycle.whenStarted
import com.example.lifecycletest.databinding.FragmentFirstBinding
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.coroutines.coroutineContext
import kotlin.math.log

class FirstFragment : BaseFragment<FragmentFirstBinding>(R.layout.fragment_first) {
    companion object {
        fun getInstance(): FirstFragment = FirstFragment().apply {
            arguments = bundleOf()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //repeatOnLifecycleStart()
        launchWhenStarted()

        binding.button.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.frame_layout, SecondFragment.getInstance())
                addToBackStack(null)
            }.commit()
        }
    }

    private fun repeatOnLifecycleStart() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(state = Lifecycle.State.STARTED) {
                logging(name = "repeatOnLifecycleStart")
            }
        }
    }

    private fun launchWhenStarted() {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            logging(name = "launchWhenStarted")
        }
    }

    private suspend fun logging(name: String) {
        var index = 0;
        while (true) {
            delay(1000L)
            println("[$name] .... $index")

            index++
        }
    }
}