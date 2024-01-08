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
import kotlinx.coroutines.launch
import kotlin.math.log


class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private val vm: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /*supportFragmentManager.beginTransaction().apply {
            add(binding.frameLayout.id, FirstFragment.getInstance())
        }.commit()*/

        vm.run()

        //repeatOnLifecycleStarted()
        launchWhenStarted()
    }

    private fun repeatOnLifecycleStarted() {
        lifecycleScope.launch {
            repeatOnLifecycle(state = Lifecycle.State.STARTED) {
                vm.state.collectLatest {
                    Log.e("jms8732", "repeatOnLifecycleStarted: $it")
                }
            }
        }
    }
    
    private fun launchWhenStarted(){
        lifecycleScope.launchWhenStarted { 
            vm.state.collectLatest {
                Log.e("jms8732", "launchWhenStarted: $it", )
            }
        }
    }
}