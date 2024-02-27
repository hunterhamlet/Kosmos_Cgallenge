package com.hamon.kosmos_challenge.domain.use_case

import com.hamon.kosmos_challenge.data.repository_impl.RickAndMortyRepositoryImpl
import com.hamon.kosmos_challenge.domain.model.CharacterDomain
import com.hamon.kosmos_challenge.domain.repository.RickAndMortyRepository
import com.hamon.kosmos_challenge.network.events.ServiceResponse
import com.hamon.kosmos_challenge.utils.ext.toDomain

interface GetCharactersUseCase {

    suspend operator fun invoke(): ServiceResponse<MutableList<CharacterDomain>>
}

class GetCharacterUserCaseImpl(val repository: RickAndMortyRepository) : GetCharactersUseCase {

    override suspend operator fun invoke(): ServiceResponse<MutableList<CharacterDomain>> {
        return if (repository.getCharacters().isNotEmpty()) {

            // Transform data
            val listTransform = repository.getCharacters().map { character -> character.toDomain() }

            // Send Success response
            ServiceResponse.Success<MutableList<CharacterDomain>>(data = listTransform.toMutableList())
        } else {
            ServiceResponse.Error(message = "La lista esta vacia")
        }
    }

}