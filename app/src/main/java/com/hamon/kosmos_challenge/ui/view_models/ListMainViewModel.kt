package com.hamon.kosmos_challenge.ui.view_models

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hamon.kosmos_challenge.domain.model.CharacterDomain
import com.hamon.kosmos_challenge.domain.use_case.GetCharacterUserCaseImpl
import com.hamon.kosmos_challenge.domain.use_case.GetCharactersUseCase
import com.hamon.kosmos_challenge.network.events.ServiceResponse
import com.hamon.kosmos_challenge.ui.model.CharacterUI
import com.hamon.kosmos_challenge.ui.states.StateUI
import com.hamon.kosmos_challenge.utils.ext.toUIModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ListMainViewModel: ViewModel() {

    private val _uiState = MutableStateFlow<MutableList<CharacterUI>>(mutableListOf())
    val uiState: StateFlow<MutableList<CharacterUI>> = _uiState.asStateFlow()

    private val getCharactersUseCase: GetCharactersUseCase by lazy {
        GetCharacterUserCaseImpl()
    }

    fun getCharacters() {
        viewModelScope.launch(Dispatchers.IO) {

            // Get characters and check data
            handleServiceResponse(getCharactersUseCase())

        }
    }

    private fun handleServiceResponse(result: ServiceResponse<MutableList<CharacterDomain>>) {
        viewModelScope.launch {
            when (result) {
                is ServiceResponse.Success<MutableList<CharacterDomain>> -> {
                    _uiState.emit(result.data.map { characterDomain -> characterDomain.toUIModel() }
                        .toMutableList())
                }

                is ServiceResponse.Error -> {
                    _uiState.emit(mutableListOf())
                }
            }
        }
    }



}