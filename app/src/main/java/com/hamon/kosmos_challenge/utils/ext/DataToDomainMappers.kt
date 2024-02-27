package com.hamon.kosmos_challenge.utils.ext

import com.hamon.kosmos_challenge.data.model.Character
import com.hamon.kosmos_challenge.data.model.Location
import com.hamon.kosmos_challenge.data.model.Origin
import com.hamon.kosmos_challenge.domain.model.CharacterDomain
import com.hamon.kosmos_challenge.domain.model.LocationDomain
import com.hamon.kosmos_challenge.domain.model.OriginDomain

fun Origin.toDomain(): OriginDomain = OriginDomain(name = name ?: "", url = url ?: "")

fun Location.toDomain(): LocationDomain = LocationDomain(name = name ?: "", url = url ?: "")

fun Character.toDomain(): CharacterDomain = CharacterDomain(
    created = created ?: "",
    episode = episode?.filterNotNull() ?: listOf(),
    gender = gender ?: "",
    id = id ?: 0,
    image = image ?: "",
    location = location?.toDomain() ?: LocationDomain.builderEmpty(),
    name = name ?: "",
    origin = origin?.toDomain() ?: OriginDomain.builderEmpty(),
    species = species ?: "",
    status = status ?: "",
    type = type ?: "",
    url = url ?: ""
)