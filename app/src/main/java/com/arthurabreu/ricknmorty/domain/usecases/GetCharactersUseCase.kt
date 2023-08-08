package com.arthurabreu.ricknmorty.domain.usecases

import com.arthurabreu.ricknmorty.data.characters.UICharacters
import com.arthurabreu.ricknmorty.domain.RMClient

class GetCharactersUseCase(
    private val client: RMClient
) {
    suspend fun execute(): List<UICharacters> {
        return client.getCharacters()
    }
}