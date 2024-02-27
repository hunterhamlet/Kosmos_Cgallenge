package com.hamon.kosmos_challenge.domain.model

import com.google.gson.annotations.SerializedName

data class OriginDomain(
    val name: String,
    val url: String
) {
    companion object {
        fun builderEmpty() = OriginDomain(name = "", url = "")
    }
}