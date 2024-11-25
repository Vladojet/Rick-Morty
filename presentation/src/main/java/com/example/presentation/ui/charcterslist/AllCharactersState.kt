package com.example.presentation.ui.charcterslist

import com.example.domain.models.MultiverseCharacter
import com.example.presentation.base.BaseState

data class AllCharactersState(
    val balancesList: List<MultiverseCharacter> = listOf(),
    val isRefreshing: Boolean = false
): BaseState()