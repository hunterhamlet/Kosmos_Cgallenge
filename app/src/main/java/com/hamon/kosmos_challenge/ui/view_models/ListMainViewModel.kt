package com.hamon.kosmos_challenge.ui.view_models

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hamon.kosmos_challenge.domain.model.CharacterDomain
import com.hamon.kosmos_challenge.domain.use_case.GetCharacterUserCaseImpl
import com.hamon.kosmos_challenge.domain.use_case.GetCharactersUseCase
import com.hamon.kosmos_challenge.network.events.ServiceResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListMainViewModel: ViewModel() {

    private val getCharactersUseCase: GetCharactersUseCase by lazy {
        GetCharacterUserCaseImpl()
    }

    init {
        getCharacters()
    }

    fun getCharacters() {
        viewModelScope.launch(Dispatchers.IO) {

            // Get characters and check data
            handleServiceResponse(getCharactersUseCase())

        }
    }

    fun handleServiceResponse(result: ServiceResponse<MutableList<CharacterDomain>>) {
        when(result) {
            is ServiceResponse.Success<MutableList<CharacterDomain>> -> {
                Log.d("JHMM", "characterList: ${result.data.size}")
            }
            is ServiceResponse.Error -> {
                Log.d("JHMM", "Error")
            }
        }
    }



}