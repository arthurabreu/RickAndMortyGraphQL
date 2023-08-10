package com.arthurabreu.ricknmorty.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavOptions
import androidx.navigation.Navigator
import com.arthurabreu.ricknmorty.util.EnterTransitionAnim
import com.arthurabreu.ricknmorty.util.ExitTransitionAnim
import com.arthurabreu.ricknmorty.util.PopEnterTransitionAnim
import com.arthurabreu.ricknmorty.util.PopExitTransitionAnim

@OptIn(ExperimentalAnimationApi::class)
abstract class NavigationAction {

    abstract val route: String

    open val navOptions = NavOptions.Builder().setLaunchSingleTop(true).build()
    open val navigatorExtras: Navigator.Extras? = null
    open val arguments: List<NamedNavArgument> = listOf()

    open val enterTransition: EnterTransitionAnim = { _, _ ->
        slideInHorizontally()
    }

    open val exitTransition: ExitTransitionAnim = { _, _ ->
        slideOutHorizontally(targetOffsetX = { -1000 })
    }

    open val popEnterTransition: PopEnterTransitionAnim = { _, _ ->
        slideInHorizontally()
    }

    open val popExitTransition: PopExitTransitionAnim = { _, _ ->
        slideOutHorizontally(targetOffsetX = { 1000 })
    }

    var passedArguments = listOf<String>()

    fun withNavigationArguments(vararg args: String): NavigationAction {
        passedArguments = args.toList().map { it.ifEmpty { " " } }
        return this
    }

    companion object {
        fun String.withArgs(params: List<String>): String {
            return buildString {
                append(this@withArgs)
                params.forEach { arg ->
                    append("/$arg")
                }
            }
        }
    }
}
