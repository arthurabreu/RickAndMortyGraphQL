package com.arthurabreu.ricknmorty.navigation.destinations

import com.arthurabreu.ricknmorty.navigation.NavigationAction

sealed class CharactersDestination : NavigationAction() {

    class Characters : CharactersDestination() {
        override val route: String
            get() = CHARACTERS_DESTINATION
    }

    companion object {
        const val CHARACTERS_DESTINATION = "characters"
    }
}
