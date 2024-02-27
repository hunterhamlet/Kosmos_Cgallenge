package com.hamon.kosmos_challenge.data.repository_impl

import com.hamon.kosmos_challenge.data.datasource.RickAndMortyDataSource
import com.hamon.kosmos_challenge.data.datasource.RickAndMortyDataSourceImpl
import com.hamon.kosmos_challenge.data.model.Character
import com.hamon.kosmos_challenge.domain.repository.RickAndMortyRepository

class RickAndMortyRepositoryImpl : RickAndMortyRepository {

    // Create datasource
    private val dataSource: RickAndMortyDataSource by lazy {
        RickAndMortyDataSourceImpl()
    }

    override suspend fun getCharacters(): List<Character> {
        return dataSource.getCharacters()
    }

}