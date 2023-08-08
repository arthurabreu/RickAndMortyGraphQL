package com.arthurabreu.ricknmorty.data.characters

data class CharactersState(
    val characters: List<UICharacters> = emptyList(),
    val isLoading: Boolean = false
)