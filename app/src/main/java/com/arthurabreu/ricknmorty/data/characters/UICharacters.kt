package com.arthurabreu.ricknmorty.data.characters

data class UICharacters(
    val name: String? = null,
    val id: String? = null,
    val image: String? = null,
    val status: String? = null,
    val species: String? = null,
    val location: UILocation? = null,
    val gender: String? = null
)
