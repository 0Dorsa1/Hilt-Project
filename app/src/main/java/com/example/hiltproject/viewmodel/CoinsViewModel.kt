package com.example.hiltproject.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hiltproject.model.DigitalCoin
import com.example.hiltproject.network.DetailsRepository
import com.example.hiltproject.network.ListRepository
import com.example.hiltproject.network.LivePriceApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import javax.inject.Inject

@HiltViewModel
class CoinsViewModel @Inject constructor(
    private val liveApiService: LivePriceApi,
    private val retrofit: Retrofit,
    private val listRepository: ListRepository,
    private val detailsRepository: DetailsRepository
) : ViewModel() {

    // LiveData to hold the list of digital coins
    private val _coins: MutableLiveData<List<DigitalCoin>> = MutableLiveData()
    val coins: LiveData<List<DigitalCoin>> get() = _coins
//    fun fetchCoins() {
//        viewModelScope.launch {
//            try {
//                val response = listRepository.call()
//                _coins.value = response.getCoins() ?: emptyList()
//            } catch (e: Exception) {
//                // Handle exceptions here
//            }
//        }
//    }

    fun fetchDetails() {
        viewModelScope.launch {
            try {
                detailsRepository.call()
                // Handle the details response here if needed
            } catch (e: Exception) {
                // Handle exceptions here
            }
        }
    }
}
