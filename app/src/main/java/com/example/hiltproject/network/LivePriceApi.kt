package com.example.hiltproject.network

import com.example.hiltproject.model.DigitalCoin
import com.example.hiltproject.model.GetCoinListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface LivePriceApi {
    @GET("/api/liveprice-1.0.0/prices/list")
    suspend fun getCoins(
        @Query("pageSize") pageSize: Int,
        @Query("pageIndex") pageIndex: Int,
        @Query("type") type: Int
    ): GetCoinListResponse

    @GET("api/liveprice-1.0.0/prices/details")
    suspend fun getDetails(
        @Query("id") id: String
    ) : GetCoinListResponse
}

