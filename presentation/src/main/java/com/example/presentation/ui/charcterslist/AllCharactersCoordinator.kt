package com.example.presentation.ui.charcterslist

import androidx.navigation.NavController
import com.example.presentation.base.BaseCoordinator

class AllCharactersCoordinator(
    private val navController: NavController,
    private val viewModel: AllCharactersViewModel
) : BaseCoordinator<AllCharactersState, AllCharactersActions>(viewModel) {
    override fun createActions(): AllCharactersActions {
        return AllCharactersActions(
            onCardSelected = { },
            onRefresh = { },
            onSearchCharacter = { }
        )
    }
}