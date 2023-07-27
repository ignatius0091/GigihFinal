package com.tuse.afinal.network

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coil.network.HttpException
import com.tuse.afinal.models.GeometriesItem
import com.tuse.afinal.models.Result
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch


class ViewModelResult(private val apiService: ApiService): ViewModel() {
    val geometriesState: MutableStateFlow<List<GeometriesItem?>> = MutableStateFlow(emptyList())
    val loadingState: MutableState<Boolean> = mutableStateOf(true)
    val errorState: MutableState<String?> = mutableStateOf(null)

    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            try {
                val response = apiService.getData("604800")
                geometriesState.value = response.result?.objects?.output?.geometries ?: emptyList()
                loadingState.value = false
            }catch (e: HttpException){
                errorState.value = "Network Error: ${e.message}"
                loadingState.value = false
            }catch (e: Exception){
                errorState.value =  "Unknown error occurred"
                loadingState.value = false
            }
        }
    }

}
