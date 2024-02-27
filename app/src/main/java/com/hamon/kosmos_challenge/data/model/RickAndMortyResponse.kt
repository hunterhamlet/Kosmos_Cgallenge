package com.hamon.kosmos_challenge.data.model


import com.google.gson.annotations.SerializedName

data class RickAndMortyResponse(
    @SerializedName("info")
    val info: Info?,
    @SerializedName("results")
    val characters: List<Character?>?
)