package com.example.presentation

import com.example.presentation.base.BaseScreen
import kotlinx.serialization.Serializable


sealed class AppScreens: BaseScreen() {

    @Serializable
    data object AllCharactersScreen: AppScreens() {
        override val route: String
            get() = TODO("Not yet implemented")
        override val params: List<String>
            get() = TODO("Not yet implemented")
        override val title: Int
            get() = TODO("Not yet implemented")
        override val showTopBar: Boolean
            get() = TODO("Not yet implemented")

    }

    @Serializable
    data class DetailsScreen(
        val selectedIdentifier: String = ""
    ): AppScreens() {
        override val route: String
            get() = TODO("Not yet implemented")
        override val params: List<String>
            get() = TODO("Not yet implemented")
        override val title: Int
            get() = TODO("Not yet implemented")
        override val showTopBar: Boolean
            get() = TODO("Not yet implemented")

    }
}