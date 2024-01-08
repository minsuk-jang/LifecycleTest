package com.example.lifecycletest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.lifecycletest.databinding.ActivityMainBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlin.math.log


class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private val vm: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /*supportFragmentManager.beginTransaction().apply {
            add(binding.frameLayout.id, FirstFragment.getInstance())
        }.commit()*/

        repeatOnLifecycleStarted()
        launchWhenStarted()
    }

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