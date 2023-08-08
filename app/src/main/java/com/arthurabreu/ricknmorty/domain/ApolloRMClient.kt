package com.arthurabreu.ricknmorty.domain

import com.apollographql.apollo3.ApolloClient
import com.arthurabreu.CharactersQuery
import com.arthurabreu.ricknmorty.data.characters.UICharacters
import com.arthurabreu.ricknmorty.data.characters.toUICharacters

class ApolloRMClient(
    private val apolloClient: ApolloClient
): RMClient {
    override suspend fun getCharacters(): List<UICharacters> {
        return apolloClient
            .query(CharactersQuery())
            .execute()
            .data
            ?.characters
            ?.results
            ?.map {
                it?.toUICharacters() ?: UICharacters()
            }
            ?: emptyList()
    }
}