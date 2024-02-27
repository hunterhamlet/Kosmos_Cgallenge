package com.hamon.kosmos_challenge.utils.ext

import com.hamon.kosmos_challenge.domain.model.CharacterDomain
import com.hamon.kosmos_challenge.ui.model.CharacterUI

fun CharacterDomain.toUIModel(): CharacterUI = CharacterUI(
    id = id,
    image = image,
    name = name,
    type = type,
    status = status,
    species = species,
    gender = gender,
    locationName = location.name,
    originName = origin.name
)