package com.example.lifecycletest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.lifecycletest.databinding.ActivityMainBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.math.log


class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    companion object {
        val TAG = MainActivity.javaClass.name
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        repeatOnLifecycleTest()
        launchCreateWhenTest()


        binding.button.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
            //finish()
        }
    }

    private fun repeatOnLifecycleTest() {
        lifecycleScope.launch {
            repeatOnLifecycle(state = Lifecycle.State.STARTED) {
                loop("repeatOnLifecycleTest")
            }
        }
    }

    private fun launchCreateWhenTest() {
        lifecycleScope.launchWhenStarted {
            launch {
                loop(message = "launchStartedWhen")
            }
        }
    }

    private suspend fun loop(message: String) {
        var i = 0
        while (true) {
            Log.e(TAG, "$message: $i")
            delay(1000L)
            i++
        }
    }
}