package com.tuse.afinal.ui.screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.tuse.afinal.DisasterApplication
import com.tuse.afinal.data.DisasterGeometriesRepository
import com.tuse.afinal.model.Geometry
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface DisasterUiState{
    data class Success(val geometries: List<Geometry>): DisasterUiState

    object Error: DisasterUiState

    object Loading: DisasterUiState

}

class DisasterViewModel(private val disasterGeometriesRepository: DisasterGeometriesRepository) : ViewModel(){
    var disasterUiState: DisasterUiState by mutableStateOf(DisasterUiState.Loading)
        private set

    init {
        getDisasterGeometries()
    }

    fun getDisasterGeometries(){
        viewModelScope.launch {
            disasterUiState = try {
                val result = disasterGeometriesRepository.getDisasterGeometries()
                DisasterUiState.Success(result)
            }catch (e: IOException){
                DisasterUiState.Error
            }
        }
    }

    companion object{
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as DisasterApplication)
                val disasterGeometriesRepository = application.container.disasterRepository
                DisasterViewModel(disasterGeometriesRepository = disasterGeometriesRepository)
            }
        }
    }
}

