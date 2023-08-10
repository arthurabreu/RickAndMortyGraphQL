package com.arthurabreu.ricknmorty.navigation.destinations

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.arthurabreu.ricknmorty.navigation.NavigationAction
import com.arthurabreu.ricknmorty.ui.characters.CharactersScreen

private fun NavGraphBuilder.createDestination(
    destination: NavigationAction,
    vararg pathArgs: String,
    content: @Composable () -> Unit
) {
    composable(
        route = destination.route
            .withPathArgs(
                *pathArgs
            ),
        arguments = destination.arguments
    ) {
        content()
    }
}

private fun String.withPathArgs(vararg nameArgs: String) = buildString {
    append(this@withPathArgs)
    nameArgs.forEach { name ->
        append("/{$name}")
    }
}
fun NavGraphBuilder.charactersDestinations() {
    createDestination(
        CharactersDestination.Characters()
    ) {
        CharactersScreen()
    }
}