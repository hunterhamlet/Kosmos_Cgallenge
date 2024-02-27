package com.hamon.kosmos_challenge.network.services

import com.hamon.kosmos_challenge.data.model.RickAndMortyResponse
import com.hamon.kosmos_challenge.network.CHARACTER_LIST
import retrofit2.Response
import retrofit2.http.GET

interface RickAndMortyServices {

    @GET(CHARACTER_LIST)
    suspend fun getCharacterList() : Response<RickAndMortyResponse>

}