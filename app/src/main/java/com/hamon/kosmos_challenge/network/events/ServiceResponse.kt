package com.hamon.kosmos_challenge.network.events

sealed class ServiceResponse<out T> {
    class Success<T>(val data: T) : ServiceResponse<T>()
    class Error(val message: String) : ServiceResponse<Nothing>()
}