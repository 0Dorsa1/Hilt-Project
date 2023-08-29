package com.example.hiltproject.network

import com.example.hiltproject.di.RetrofitModule
import javax.inject.Inject

class Repository @Inject constructor(val api: RetrofitModule) {
}