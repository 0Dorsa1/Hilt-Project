package com.example.hiltproject.network

import com.example.hiltproject.model.GetCoinListResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ListRepository @Inject constructor(val api: LivePriceApi) {

    fun call(): Flow<GetCoinListResponse> {
        return flow {
            val response = api.getCoins(
                pageSize = 10,
                pageIndex = 0,
                type = 1
            )
            emit(response)
        }
    }
}