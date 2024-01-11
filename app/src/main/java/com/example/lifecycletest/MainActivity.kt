package com.example.lifecycletest

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.lifecycletest.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private val vm: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        repeatOnLifecycleStarted()
        launchWhenStarted()
    }


    //TODO: 시스템에서 값이 나오는 형태로
    private fun repeatOnLifecycleStarted() {
        lifecycleScope.launch {
            repeatOnLifecycle(state = Lifecycle.State.STARTED) {
                vm.state.collectLatest {
                    binding.textViewOne.text = "repeatOnLifecycleStarted: $it"
                }
            }
        }
    }

    private fun launchWhenStarted() {
        lifecycleScope.launchWhenStarted {
            vm.state1.collectLatest {
                binding.textViewTwo.text = "launchWhenStarted: $it"
            }
        }
    }
}