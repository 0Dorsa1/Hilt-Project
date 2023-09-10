package com.example.hiltproject.ui.list

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.hiltproject.model.DigitalCoin
import com.example.hiltproject.model.GetCoinListResponse
import com.example.hiltproject.ui.list.viewmodel.CoinsListViewModel

@Preview
@Composable
private fun Preview() {

    ContentSection(
        CoinsListViewModel.ScreenState(
            isLoading = false,
            isError = false,
            response = GetCoinListResponse(
                data = arrayListOf(
                    DigitalCoin(
                        date = 10000,
                        symbol = "ABC",
                        priceDif1Day = "10%",
                        price = "26000",
                        lastUpdate = "",
                        name = "Bitcoin",
                        icon ="",
                        id = "123",
                        lastPrice = 10000.0
                    ),
                    DigitalCoin(
                        date = 10000,
                        symbol = "DEF",
                        priceDif1Day = "10%",
                        price = "26000",
                        lastUpdate = "",
                        name = "Bitcoin",
                        icon ="",
                        id = "123",
                        lastPrice = 10000.0
                    )
                ),
                status = true,
            )

        ),
        coinListOnRetry = {}
    )
}

@Composable
fun CoinsListScreen(
    coinListViewModel: CoinsListViewModel = viewModel()
) {
    var onCreate by remember { mutableStateOf(true) }

    LaunchedEffect(key1 = onCreate) {
        if (onCreate) {
            coinListViewModel.call(
                pageSize = 10,
                pageIndex = 0,
                type = 1
            )
            onCreate = false
        }
    }

    ContentSection(
        coinListState = coinListViewModel.state,
        coinListOnRetry = {
            coinListViewModel.call(
                pageSize = 10,
                pageIndex = 0,
                type = 1
            )
        }
    )
}

@Composable
private fun ContentSection(
    coinListState: CoinsListViewModel.ScreenState,
    coinListOnRetry: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (coinListState.isLoading) {
            CircularProgressIndicator()
        } else if (coinListState.isError) {
            Text(
                modifier = Modifier.clickable {
                    coinListOnRetry()
                },
                text = "Loading failed, click to retry"
            )
        } else {
            Column {
                coinListState.response?.data?.forEach { item ->
                    Text(text = item.symbol)
                }
            }
        }
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
