package com.example.hiltproject.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.hiltproject.di.RetrofitModule
import com.example.hiltproject.model.DigitalCoin
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinsViewModel @Inject constructor(
    application: Application,
    private val apiService: RetrofitModule
) : AndroidViewModel(application) {

    private val _coins: MutableLiveData<List<DigitalCoin>> = MutableLiveData()

    // Expose the LiveData to observe in Composables
    val coins: LiveData<List<DigitalCoin>> get() = _coins

//    init {
//        fetchCoins()
//    }

//    private fun fetchCoins() {
//        viewModelScope.launch {
//            try {
//                val response = apiService.getCoins()
//                if (response.isSuccessful) {
//                    val coinList = response.body()
//                    _coins.value = coinList
//                } else {
//                    // Handle API error
//                }
//            } catch (e: Exception) {
//                // Handle network or other errors
//            }
//        }
//    }
}
