package com.arthurabreu.ricknmorty.data

import com.arthurabreu.CharactersQuery

fun CharactersQuery.Result.toUICharacters(): UICharacters {
    return UICharacters(
        name = name,
        id = id,
        image = image,
        status = status,
        species = species,
        location = location?.toUILocation(),
        gender = gender
    )
}

fun CharactersQuery.Location.toUILocation(): UILocation {
    return UILocation(
        name = name,
        id = id
    )
}