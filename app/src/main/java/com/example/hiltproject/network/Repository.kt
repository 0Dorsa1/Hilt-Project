package com.example.hiltproject.network

import android.util.Log
import com.example.hiltproject.model.DigitalCoin
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class Repository @Inject constructor(val api: LivePriceApi) {
    lateinit var response:List<DigitalCoin>
    fun call(){
        CoroutineScope(Dispatchers.Main).launch {
            response=api.getCoins(
                pageSize = 10,
                pageIndex = 0,
                type = 1
            )
        }

        Log.d("response",response.get(0).toString())
    }
}