package com.hamon.kosmos_challenge.domain.model

import com.google.gson.annotations.SerializedName
import com.hamon.kosmos_challenge.data.model.Location
import com.hamon.kosmos_challenge.data.model.Origin

data class CharacterDomain(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: LocationDomain,
    val name: String,
    val origin: OriginDomain,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)