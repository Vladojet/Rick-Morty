package com.example.presentation.base

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

interface ViewModelFactory<out V : ViewModel> {
    fun create(handle: SavedStateHandle): V
}

@Composable
inline fun <reified T : ViewModel> koinViewModel(
    key: String? = null,
    crossinline viewModelInstanceCreator: (SavedStateHandle) -> T
): T =
    viewModel(
        modelClass = T::class.java,
        key = key,
        factory = object : AbstractSavedStateViewModelFactory() {
            override fun <T : ViewModel> create(
                key: String,
                modelClass: Class<T>,
                handle: SavedStateHandle
            ): T {
                return viewModelInstanceCreator(handle) as T
            }
        }
    )

@Composable
fun <T: BaseState, T1: BaseScreenAction, T2: BaseCoordinator<T, T1>> rememberActions(
    coordinator: T2
): T1 {
    return remember(coordinator) {
        coordinator.createActions()
    }
}