package com.example.rickandmorty.utils

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavDeepLink
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable
import com.example.presentation.base.BaseScreen
import com.example.rickandmorty.main.MainActivityViewModel

fun <T : Any> NavController.navigateSingleTop(
    screen: T,
    builder: NavOptionsBuilder.() -> Unit = {}
) = navigate(screen) {
    launchSingleTop = true
    builder()
}

inline fun <reified T : BaseScreen> NavGraphBuilder.composableScreen(
    viewModel: MainActivityViewModel,
    screen: T,
    deepLinks: List<NavDeepLink> = emptyList(),
    titleArgument: String = "",
    overrideReturnButton: Boolean = false,
    crossinline block: @Composable (NavBackStackEntry) -> Unit
) {
    composable<T>(
        deepLinks = deepLinks,
        enterTransition =  {
            slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.Left,
                animationSpec = tween(700)
            )
        },
        exitTransition = {
            slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.Left,
                animationSpec = tween(700)
            )
        },
        popEnterTransition = {
            slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.Right,
                animationSpec = tween(700)
            )
        },
        popExitTransition = {
            slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.Right,
                animationSpec = tween(700)
            )
        }
    ) {
        LaunchedEffect(screen) {
            val title = if (titleArgument.isNotEmpty())
                it.arguments?.getString(titleArgument) ?: ""
            else ""

            viewModel.updateCurrentScreen(screen, title, overrideReturnButton)
        }
        block(it)
    }
}