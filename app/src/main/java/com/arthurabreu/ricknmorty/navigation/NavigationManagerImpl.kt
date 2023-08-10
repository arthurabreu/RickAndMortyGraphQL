package com.arthurabreu.ricknmorty.navigation

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow

class NavigationManagerImpl : NavigationManager {

    private val _navActions: MutableSharedFlow<NavigationCommand> =
        MutableSharedFlow(extraBufferCapacity = 1)

    override val navActions: SharedFlow<NavigationCommand> = _navActions.asSharedFlow()

    override fun navigate(command: NavigationCommand) {
        _navActions.tryEmit(command)
    }
}
