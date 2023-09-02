package com.example.hiltproject.network

import com.example.hiltproject.model.DigitalCoin
import retrofit2.http.GET
import retrofit2.http.Query

interface LivePriceApi {
    @GET("priceList")
    suspend fun getCoins(
        @Query("pageSize") pageSize: Int,
        @Query("pageIndex") pageIndex: Int,
        @Query("type") type: Int
    ): List<DigitalCoin>
}