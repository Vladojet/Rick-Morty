package com.example.presentation.ui.charcterslist

import com.example.presentation.base.BaseScreenAction

class AllCharactersActions(
    val onCardSelected: () -> Unit,
    val onRefresh: () -> Unit,
    val onSearchCharacter: () -> Unit
) : BaseScreenAction() {
}