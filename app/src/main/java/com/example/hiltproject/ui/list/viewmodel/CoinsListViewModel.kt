package com.example.hiltproject.ui.list.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hiltproject.model.GetCoinListResponse
import com.example.hiltproject.ui.list.repository.CoinListRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinsListViewModel @Inject constructor(private val repository: CoinListRepository) : ViewModel() {
    var state by mutableStateOf(ScreenState())

   fun call(pageSize: Int, pageIndex: Int, type: Int){
       viewModelScope.launch {
           state = state.copy(
               isLoading = true,
               isError = false
           )

           delay(6000)

           repository.call(
               pageSize = pageSize,
               pageIndex = pageIndex,
               type = type
           )
               .catch { _ ->
                   state = state.copy(
                       isLoading = false,
                       isError = true
                   )
               }
               .collectLatest { response ->
                   state = state.copy(
                       response = response,
                       isLoading = false,
                       isError = false
                   )
               }
       }
   }

    data class ScreenState(
        var isLoading: Boolean = false,
        var isError: Boolean = false,
        var response: GetCoinListResponse? = null
    )
}
