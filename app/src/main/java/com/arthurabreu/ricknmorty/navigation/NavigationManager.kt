package com.arthurabreu.ricknmorty.navigation

import kotlinx.coroutines.flow.SharedFlow

interface NavigationManager {
    val navActions: SharedFlow<NavigationCommand>
    fun navigate(command: NavigationCommand)
}