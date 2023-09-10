package com.example.hiltproject.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.hiltproject.model.DigitalCoin
import com.example.hiltproject.model.GetCoinListResponse


@Composable
fun CoinsList(coins: GetCoinListResponse) {
    LazyColumn {
//        items(coins.value ?: emptyList()) { coin ->
//            CoinItem(coin = coin)
//        }
    }
}



@Composable
fun CoinItem(coin: DigitalCoin) {
    Column(
        modifier = Modifier
            .padding(16.dp)
    ) {

    }
}
