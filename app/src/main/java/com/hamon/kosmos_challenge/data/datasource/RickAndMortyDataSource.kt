package com.hamon.kosmos_challenge.data.datasource

import com.hamon.kosmos_challenge.data.model.Character
import com.hamon.kosmos_challenge.network.API
import com.hamon.kosmos_challenge.network.services.RickAndMortyServices

interface RickAndMortyDataSource {

    suspend fun getCharacters(): List<Character>

}

class RickAndMortyDataSourceImpl : RickAndMortyDataSource {

    // Move to DI
    private val client by lazy {
        API.getServices<RickAndMortyServices>()
    }

    override suspend fun getCharacters(): List<Character> {
        return runCatching {

            // Request
            val result = client.getCharacterList()

            // Check request
            if (result.isSuccessful) {
                result.body()?.characters?.filterNotNull() ?: listOf<Character>()
            } else {
                listOf<Character>()
            }

        }.getOrElse {
            listOf<Character>()
        }
    }

}