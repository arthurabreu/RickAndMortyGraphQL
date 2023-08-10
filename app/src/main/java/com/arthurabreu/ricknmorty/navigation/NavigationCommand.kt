package com.arthurabreu.ricknmorty.navigation

sealed class NavigationCommand {
    data class Navigate(val navAction: NavigationAction) : NavigationCommand()
    data class PopUpTo(val route: String, val inclusive: Boolean) : NavigationCommand()
    object Back : NavigationCommand()
}
