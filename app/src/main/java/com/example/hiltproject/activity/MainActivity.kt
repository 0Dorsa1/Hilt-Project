package com.example.hiltproject.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.hiltproject.R
import com.example.hiltproject.model.GetCoinListResponse
import com.example.hiltproject.network.ListRepository
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    var list: GetCoinListResponse? = null

    @Inject
    lateinit var repository: ListRepository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lifecycleScope.launch {
            repository.call()
                .catch { exception ->
                    Toast.makeText(this@MainActivity, "Exception!!!", Toast.LENGTH_SHORT).show()
                }
                .collectLatest { response ->
                    list = response
                }
        }
    }
}