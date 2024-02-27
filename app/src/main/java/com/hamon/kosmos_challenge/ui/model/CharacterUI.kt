package com.hamon.kosmos_challenge.ui.model

import com.hamon.kosmos_challenge.domain.model.LocationDomain
import com.hamon.kosmos_challenge.domain.model.OriginDomain

data class CharacterUI(
    val gender: String,
    val id: Int,
    val image: String,
    val locationName: String,
    val name: String,
    val originName: String,
    val species: String,
    val status: String,
    val type: String,
)