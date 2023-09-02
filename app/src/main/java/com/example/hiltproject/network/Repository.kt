package com.example.hiltproject.network

import android.util.Log
import com.example.hiltproject.model.DigitalCoin
import javax.inject.Inject

class Repository @Inject constructor(val api: LivePriceApi) {
    private var response: List<DigitalCoin>? = null // Use nullable type to indicate it's not initialized

    suspend fun call() {
        try {
            response = api.getCoins(
                pageSize = 10,
                pageIndex = 0,
                type = 1
            )
            Log.d("response", response?.get(0).toString()) // Access response here
        } catch (e: Exception) {
            // Handle exceptions
            Log.e("error", e.message ?: "Unknown error")
        }
    }
}
