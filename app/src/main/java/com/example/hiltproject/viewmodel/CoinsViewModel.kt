package com.example.hiltproject.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.hiltproject.model.DigitalCoin
import com.example.hiltproject.network.LivePriceApi
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Retrofit
import javax.inject.Inject

@HiltViewModel
class CoinsViewModel @Inject constructor(
    application: Application,
    private val apiService: LivePriceApi, // Inject ApiService instead of RetrofitModule
    private val retrofit: Retrofit // Inject Retrofit here
) : AndroidViewModel(application) {

    private val _coins: MutableLiveData<List<DigitalCoin>> = MutableLiveData()

    val coins: LiveData<List<DigitalCoin>> get() = _coins

    // ViewModel code
}
