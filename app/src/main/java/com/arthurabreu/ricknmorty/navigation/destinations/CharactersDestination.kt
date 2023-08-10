package com.arthurabreu.ricknmorty.navigation.destinations

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.arthurabreu.ricknmorty.navigation.NavigationAction
import com.arthurabreu.ricknmorty.navigation.destinations.CharactersDestination.Companion.CHARACTER_ID
import com.arthurabreu.ricknmorty.ui.characterdetails.CharacterDetailsScreen
import com.arthurabreu.ricknmorty.ui.characters.CharactersScreen

sealed class CharactersDestination : NavigationAction() {

    class Characters : CharactersDestination() {
        override val route: String
            get() = CHARACTERS_DESTINATION
    }

    class CharacterDetails : CharactersDestination() {
        override val route: String
            get() = CHARACTER_DETAILS_DESTINATION

        override val arguments: List<NamedNavArgument>
            get() = listOf(
                navArgument(CHARACTER_ID) {
                    type = NavType.StringType
                    defaultValue = ""
                }
            )
    }

    companion object {
        const val CHARACTERS_DESTINATION = "characters"
        const val CHARACTER_DETAILS_DESTINATION = "character_details"
        const val CHARACTER_ID = "character_id"
    }
}

fun NavGraphBuilder.charactersDestinations() {
    createDestination(
        CharactersDestination.Characters()
    ) {
        CharactersScreen()
    }
    createDestination(
        CharactersDestination.CharacterDetails(),
        CHARACTER_ID
    ) {
        CharacterDetailsScreen()
    }
}
