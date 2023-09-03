package com.example.hiltproject.network

import android.util.Log
import com.example.hiltproject.model.DigitalCoin
import com.example.hiltproject.model.GetCoinListResponse
import javax.inject.Inject

class Repository @Inject constructor(val api: LivePriceApi) {
    private var response: GetCoinListResponse? = null  // Use nullable type to indicate it's not initialized

    suspend fun call() {
        try {
            response = api.getCoins(
                pageSize = 10,
                pageIndex = 0,
                type = 1
            )
        } catch (e: Exception) {
        }
    }
}
