package com.example.hiltproject.network

import android.util.Log
import com.example.hiltproject.model.DigitalCoin
import com.example.hiltproject.model.GetCoinListResponse
import javax.inject.Inject

class Repository @Inject constructor(val api: LivePriceApi) {
    private var response: GetCoinListResponse? = null

    suspend fun call() {
        try {
            response = api.getCoins(
                pageSize = 10,
                pageIndex = 0,
                type = 1
            )
            val a = 1
        } catch (e: Exception) {
            val a = 1
        }
    }



}

class DetailsRepository @Inject constructor(val api: LivePriceApi){
    private var response: GetCoinListResponse? = null
    suspend fun call() {
        try {
            response = api.getDetails(
                id= "61f3e31f23f1f2048a87d945"
            )
            val b = 1
        } catch (e: Exception) {
            val b = 1
        }
    }
}
