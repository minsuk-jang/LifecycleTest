package com.example.lifecycletest

import android.os.Bundle
import android.util.Log
import com.example.lifecycletest.databinding.ActivitySecondBinding

class SecondActivity : BaseActivity<ActivitySecondBinding>(R.layout.activity_second) {
    companion object {
        val TAG: String = SecondActivity.javaClass.name
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.e(TAG, "onCreate: ")
    }
}