package com.hamon.kosmos_challenge.ui.states

sealed class StateUI{
    object Init: StateUI()
    object Loading: StateUI()
    class Success<T>(val data: T) : StateUI()
    class Error(val message: String) : StateUI()
}