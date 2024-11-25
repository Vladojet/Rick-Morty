package com.example.rickandmorty.main

import com.example.presentation.AppScreens
import com.example.presentation.base.BaseScreen
import com.example.presentation.base.BaseState
import com.example.presentation.utils.StringResourceHelper
import com.example.presentation.utils.StringResourceHelperI

data class MainActivityState(
    val currentScreen: BaseScreen = AppScreens.AllCharactersScreen,
    val title: StringResourceHelperI = StringResourceHelper.defaultValue,
    val overrideReturnButton: Boolean = false,
) : BaseState()