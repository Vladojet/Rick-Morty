package com.example.presentation.base

abstract class BaseCoordinator<T: BaseState, T1: BaseScreenAction>(
    viewModel: BaseViewModel<T>
) {
    val uiState = viewModel.uiState
    val progressBarIsShown = viewModel.progressBarIsShown
    val snackState = viewModel.snackState

    abstract fun createActions(): T1
}