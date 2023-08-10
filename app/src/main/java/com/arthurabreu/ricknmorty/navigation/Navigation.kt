package com.arthurabreu.ricknmorty.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.arthurabreu.ricknmorty.navigation.NavigationAction.Companion.withArgs
import com.arthurabreu.ricknmorty.navigation.destinations.CharactersDestination
import com.arthurabreu.ricknmorty.navigation.destinations.charactersDestinations
import kotlinx.coroutines.flow.collectLatest

@Composable
fun MainComposable(
    navigator: Navigator
) {
    Navigation(navigator = navigator)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Navigation(
    navigator: Navigator
) {
    val navController = rememberNavController()

    LaunchedEffect(key1 = true) {
        navigator.navigationCommands.collectLatest { navCommand ->
            when (navCommand) {
                NavigationCommand.Back -> navController.navigateUp()
                is NavigationCommand.Navigate -> {
                    if (navController.currentDestination?.route != navCommand.navAction.route) {
                        navController.navigate(
                            route = navCommand.navAction.route
                                .withArgs(navCommand.navAction.passedArguments),
                            navOptions = navCommand.navAction.navOptions,
                            navigatorExtras = navCommand.navAction.navigatorExtras
                        )
                    }
                }
                is NavigationCommand.PopUpTo -> navController.popBackStack(
                    navCommand.route,
                    navCommand.inclusive
                )
            }
        }
    }

    Scaffold(
        modifier = Modifier
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            contentAlignment = Alignment.Center,
        ) {
            NavHost(
                navController = navController,
                startDestination = CharactersDestination.Characters().route
            ) {
                charactersDestinations()
            }
        }
    }
}


