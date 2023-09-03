package com.example.hiltproject.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hiltproject.R
import com.example.hiltproject.network.LivePriceApi
import com.example.hiltproject.network.Repository
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

//    @Inject
//    lateinit var repository:Repository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        CoroutineScope(Dispatchers.Main).launch {
//
//            repository.call()
//        }
    }
}