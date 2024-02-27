package com.hamon.kosmos_challenge.domain.repository

import com.hamon.kosmos_challenge.data.model.Character

interface RickAndMortyRepository {

    suspend fun getCharacters(): List<Character>

}