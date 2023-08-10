@file:OptIn(ExperimentalAnimationApi::class)

package com.arthurabreu.ricknmorty.util

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavBackStackEntry

typealias EnterTransitionAnim = (
    AnimatedContentScope<String>.(
        initial: NavBackStackEntry,
        target: NavBackStackEntry
    ) -> EnterTransition?
)?

typealias ExitTransitionAnim = (
    AnimatedContentScope<String>.(
        initial: NavBackStackEntry,
        target: NavBackStackEntry
    ) -> ExitTransition?
)?

typealias PopEnterTransitionAnim = (
    AnimatedContentScope<String>.(
        initial: NavBackStackEntry,
        target: NavBackStackEntry
    ) -> EnterTransition?
)?

typealias PopExitTransitionAnim = (
    AnimatedContentScope<String>.(
        initial: NavBackStackEntry,
        target: NavBackStackEntry
    ) -> ExitTransition?
)?
