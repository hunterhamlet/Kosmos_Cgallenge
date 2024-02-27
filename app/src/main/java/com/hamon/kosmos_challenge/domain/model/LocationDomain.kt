package com.hamon.kosmos_challenge.domain.model

data class LocationDomain(
    val name: String,
    val url: String
) {
    companion object {
        fun builderEmpty(): LocationDomain = LocationDomain(name = "", url = "")
    }
}