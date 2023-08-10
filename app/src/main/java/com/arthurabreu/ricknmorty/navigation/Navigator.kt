package com.arthurabreu.ricknmorty.navigation

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Navigator @Inject constructor(
    private val navigationManager: NavigationManager
) {

    val navigationCommands: Flow<NavigationCommand> = navigationManager.navActions

    fun navigateTo(navAction: NavigationAction) {
        navigationManager.navigate(NavigationCommand.Navigate(navAction))
    }

    fun navigateBack() {
        navigationManager.navigate(NavigationCommand.Back)
    }

    fun popUpTo(route: String, inclusive: Boolean) {
        navigationManager.navigate(NavigationCommand.PopUpTo(route, inclusive))
    }
}
